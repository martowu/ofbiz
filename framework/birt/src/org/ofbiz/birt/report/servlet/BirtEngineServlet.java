/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package org.ofbiz.birt.report.servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.report.context.IContext;
import org.eclipse.birt.report.service.BirtReportServiceFactory;
import org.eclipse.birt.report.service.ReportEngineService;
import org.ofbiz.base.util.UtilGenerics;
import org.ofbiz.birt.BirtWorker;
import org.ofbiz.birt.report.context.OFBizBirtContext;

@SuppressWarnings("serial")
public class BirtEngineServlet extends org.eclipse.birt.report.servlet.BirtEngineServlet {

    public final static String module = BirtEngineServlet.class.getName();

    @Override
    protected IContext __getContext(HttpServletRequest request, HttpServletResponse response) throws BirtException {
        BirtReportServiceFactory.getReportService().setContext(getServletContext( ), null);
        
        // set app context
        Map<String, Object> appContext = UtilGenerics.cast(ReportEngineService.getInstance().getEngineConfig().getAppContext());
        BirtWorker.setWebContextObjects(appContext, request, response);
        
        return new OFBizBirtContext( request, response );
    }
}
