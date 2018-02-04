package com.wikrgroup.exercise.core.selenium;

import com.wikrgroup.exercise.core.exceptions.NotImplementedException;

/**
 * Created by vlad on 07.09.17.
 */
public class BrowserFactory {
    public static Browser getBrowserInstance(Browsers browser) {
        switch (browser) {

            case CHROME: {
                return new Chrome();
            }

//            case FIREFOX: {
//                return new Firefox();
//            }
//
//            case EDGE: {
//                return new Edge();
//            }
//
//            case IE: {
//                return new Ie();
//            }
//
//            case SAFARI: {
//                return new Safari();
//            }
//
//            case PHANTOMJS: {
//                return new PhantomJs();
//            }
//
//            case HTMLUNIT: {
//                return new HtmlUnit();
//            }
        }

        throw new NotImplementedException("Browser not implemented");
    }
}
