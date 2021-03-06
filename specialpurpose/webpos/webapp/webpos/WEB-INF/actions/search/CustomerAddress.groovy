/*
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
 */
import org.ofbiz.base.util.UtilValidate;
import org.ofbiz.webpos.WebPosEvents;

webPosSession = WebPosEvents.getWebPosSession(request, null);
if (webPosSession) {
    shoppingCart = webPosSession.getCart();
    shipToCustomerPartyId = shoppingCart.getShipToCustomerPartyId();
    if (UtilValidate.isNotEmpty(shipToCustomerPartyId)) {
        context.personShipTo = delegator.findOne("Person", [partyId : shipToCustomerPartyId], false);
    }
    shippingContactMechId = shoppingCart.getContactMech("SHIPPING_LOCATION");
    if (UtilValidate.isNotEmpty(shippingContactMechId)) {
        contactMech = delegator.findOne("ContactMech", [contactMechId : shippingContactMechId], false);
        if (UtilValidate.isNotEmpty(contactMech) && "POSTAL_ADDRESS".equals(contactMech.contactMechTypeId)) {
            context.shippingPostalAddress = contactMech.getRelatedOne("PostalAddress");
        }
    }
    billToCustomerPartyId = shoppingCart.getBillToCustomerPartyId();
    if (UtilValidate.isNotEmpty(billToCustomerPartyId)) {
        context.personBillTo = delegator.findOne("Person", [partyId : billToCustomerPartyId], false);
    }
    billingContactMechId = shoppingCart.getContactMech("BILLING_LOCATION");
    if (UtilValidate.isNotEmpty(billingContactMechId)) {
        contactMech = delegator.findOne("ContactMech", [contactMechId : billingContactMechId], false);
        if (UtilValidate.isNotEmpty(contactMech) && "POSTAL_ADDRESS".equals(contactMech.contactMechTypeId)) {
            context.billingPostalAddress = contactMech.getRelatedOne("PostalAddress");
        }
    }
}