package com.developer.corson.patchdatafromstudentsys.utils;


import android.content.Context;

/**
 * 获取资源与其id对应的关系
 *
 * @author MKW
 */
public class Res {
    public static final String DRAWABLE = "drawable";
    public static final String LAYOUT = "layout";
    public static final String STRING = "string";
    public static final String INT = "int";
    public static final String COLOR = "color";
    public static final String MENU = "menu";
    public static final String RAW = "raw";

    /**
     * 通过name获取id值
     *
     * @param mContext
     * @param resName
     * @param resType
     * @return
     */
    public static int getId(Context mContext, String resName, String resType) {
        return mContext.getResources().getIdentifier(resName, resType, mContext.getPackageName());
    }

    /**
     * 通过id获取值
     *
     * @param mContext
     * @param resId
     * @return
     */
    public static String getValue(Context mContext, int resId) {
        return mContext.getString(resId);
    }

    /**
     * 通过id获取名称
     *
     * @param mContext
     * @param resId
     * @return
     */
    public static String getName(Context mContext, int resId) {
        return mContext.getResources().getResourceName(resId);
    }

    /**
     * 获取配置信息
     * 全部通过string配置
     *
     * @param mContext
     * @param configName
     *            配置名称
     * @return
     */
    public static String getConfig(Context mContext, String configName) {
        return getString(mContext, configName);
    }

    /**
     * 获取字符串
     *
     * @param mContext
     * @param resName
     * @return
     */
    public static String getString(Context mContext, String resName) {
        int id = getId(mContext, resName, Res.STRING);
        return getValue(mContext, id);
    }
}
