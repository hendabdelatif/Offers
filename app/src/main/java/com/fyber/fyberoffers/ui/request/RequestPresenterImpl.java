package com.fyber.fyberoffers.ui.request;

import com.fyber.fyberoffers.FyberOffersApplication;
import com.fyber.fyberoffers.engine.client.FyberApiClient;
import com.fyber.fyberoffers.engine.model.FyberParameter;
import com.fyber.fyberoffers.engine.tasks.GetOffersCallback;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Hend-PC on 10/7/2016.
 */

public class RequestPresenterImpl implements RequestPresenter {

    public static final String FORMAT = "format";
    public static final String APPID = "appid";
    public static final String UID = "uid";
    public static final String LOCALE = "locale";
    public static final String OS_VERSION = "os_version";
    public static final String TIMESTAMP = "timestamp";
    public static final String GOOGLE_AD_ID = "google_ad_id";
    public static final String GOOGLE_AD_ID_LIMITED_TRACKING_ENABLED = "google_ad_id_limited_tracking_enabled";
    public static final String IP = "ip";
    public static final String PUB = "pub";
    public static final String PAGE = "page";
    public static final String OFFER_TYPES = "offer_types";
    public static final String PS_TIME = "ps_time";
    public static final String DEVICE = "device";
    public static final String HASHKEY = "hashkey";
    private static final String EQUAL = "=";
    private static final String AND = "&";
    private String mFormat;
    private int mAppId;
    private String mUid;
    private String mLocale;
    private String mOsVersion;
    private long mTimestamp;
    private String mGoogleAdId;
    private Boolean mGoogleAdIdLimitedTrackingEnabled;
    private String mHashKey;
    private String mIp;
    private String mPub0;
    private Integer mPage;
    private String mOfferTypes;
    private Long mPsTime;
    private String mDevice;

    private GetOffersCallback callback = new GetOffersCallback();
    private FyberApiClient mFyberApiClient = new FyberApiClient();
    private List<FyberParameter> mParams = new ArrayList<>();
    private RequestView requestView = new RequestView.EmptyView();

    /**
     * Get all request parameters and their values (except hashkey)
     *
     * @param format
     * @param appid
     * @param uid
     * @param locale
     * @param osVersion
     * @param timestamp
     * @param googleAdId
     * @param isLimitAdTrackingEnabled
     * @param ip
     * @param customParameters
     * @param page
     * @param offerTypes
     * @param psTime
     * @param device
     */
    public RequestPresenterImpl(final String format, int appid, String uid, String locale, String osVersion, long timestamp, String googleAdId, Boolean isLimitAdTrackingEnabled,
                                String ip, String customParameters, Integer page, String offerTypes, Long psTime, String device) {


        mParams.add(new FyberParameter(FORMAT, format));
        mFormat = format;

        mParams.add(new FyberParameter(APPID, appid));
        mAppId = appid;

        mParams.add(new FyberParameter(UID, uid));
        mUid = uid;

        mParams.add(new FyberParameter(LOCALE, locale));
        mLocale = locale;

        mParams.add(new FyberParameter(OS_VERSION, osVersion));
        mOsVersion = osVersion;

        mParams.add(new FyberParameter(TIMESTAMP, timestamp));
        mTimestamp = timestamp;

        mParams.add(new FyberParameter(GOOGLE_AD_ID, googleAdId));
        mGoogleAdId = googleAdId;

        mParams.add(new FyberParameter(GOOGLE_AD_ID_LIMITED_TRACKING_ENABLED, isLimitAdTrackingEnabled));
        mGoogleAdIdLimitedTrackingEnabled = isLimitAdTrackingEnabled;

        if (ip != null) {
            mParams.add(new FyberParameter(ip, IP));
        }
        mIp = ip;

        String[] customParams = getCommaSeparatedParams(customParameters);

        // Use the first custom param
        if (customParams != null && customParams.length > 0) {
            mPub0 = customParams[0];
            mParams.add(new FyberParameter(mPub0, PUB + 0));

            // To add all params, uncomment:
            /*
                String param;
                for (int i = 0; i < customParams.length; i++) {
                    param = customParams[i];
                    mParams.add(new FyberParameter(param, PUB + i));
                }
            */
        } else {
            mPub0 = null;
        }

        if (page != null) {
            mParams.add(new FyberParameter(PAGE, page));
        }
        mPage = null;

        if (offerTypes != null) {
            mParams.add(new FyberParameter(OFFER_TYPES, offerTypes));
        }
        mOfferTypes = offerTypes;

        if (psTime != null) {
            mParams.add(new FyberParameter(PS_TIME, psTime));
        }

        mPsTime = psTime;

        if (device != null) {
            mParams.add(new FyberParameter(DEVICE, device));
        }
        mDevice = device;

        mHashKey = calculateHashKey();
    }

    private String[] getCommaSeparatedParams(String customParameters) {
        if (customParameters == null) {
            return null;
        }

        // Convert to comma separated params to be sent as pub0, pub1, and so on
        return customParameters.split(",");
    }

    /**
     * Order theses pairs alphabetically by parameter name
     */
    protected void orderByParamName() {
        Collections.sort(mParams, new Comparator<FyberParameter>() {
            @Override
            public int compare(FyberParameter lhs, FyberParameter rhs) {
                return lhs.getName().compareToIgnoreCase(rhs.getName());
            }
        });
    }

    /**
     * Concatenate all pairs using = between key and value and & between the pairs.
     *
     * @return
     */
    protected String getConcatenatedParams() {

        orderByParamName();

        FyberParameter firstParam = mParams.get(0);
        String result = firstParam.getName() + EQUAL + firstParam.getValue();
        for (int i = 1; i < mParams.size(); i++) {
            FyberParameter parameter = mParams.get(i);
            result = result + AND + parameter.getName() + EQUAL + parameter.getValue();
        }

        return result;
    }

    /**
     * Concatenate the resulting string with & and the API Key handed out to you by Fyber.
     * Hash the whole resulting string, using SHA1.
     *
     * @return
     */
    protected String calculateHashKey() {
        String concatenatedExistingParams = getConcatenatedParams();
        concatenatedExistingParams = concatenatedExistingParams + AND + FyberOffersApplication.getApiKey();
        return new String(Hex.encodeHex(DigestUtils.sha1(concatenatedExistingParams)));
    }

    @Override
    public void submit() {

        mFyberApiClient.getOffers(mFormat, mAppId, mUid, mLocale, mOsVersion, mTimestamp, mHashKey, mGoogleAdId, mGoogleAdIdLimitedTrackingEnabled, mIp, mPub0, mPage, mOfferTypes, mPsTime, mDevice, callback);

    }

    @Override
    public void setView(RequestView view) {
        requestView = view;
    }

    @Override
    public void clearView() {
        requestView = new RequestView.EmptyView();
    }
}
