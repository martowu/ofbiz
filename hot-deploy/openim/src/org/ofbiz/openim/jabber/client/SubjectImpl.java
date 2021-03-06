/*
 * BSD License http://open-im.net/bsd-license.html
 * Copyright (c) 2003, OpenIM Project http://open-im.net
 * All rights reserved.
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the OpenIM project. For more
 * information on the OpenIM project, please see
 * http://open-im.net/
 */
package org.ofbiz.openim.jabber.client;

import net.java.dev.openim.data.jabber.IMMessage;
import net.java.dev.openim.jabber.client.Subject;
import net.java.dev.openim.session.IMSession;

import org.ofbiz.openim.DefaultSessionProcessor;

public class SubjectImpl extends DefaultSessionProcessor implements Subject {
    
    public final static String module = SubjectImpl.class.getName();
    
    public void processText(final IMSession session, final Object context) throws Exception {
        ((IMMessage) context).setSubject(session.getXmlPullParser().getText());
    }
}
