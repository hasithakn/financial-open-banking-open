/**
 * Copyright (c) 2023, WSO2 LLC. (https://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.wso2.openbanking.accelerator.event.notifications.service.handler;

import com.wso2.openbanking.accelerator.event.notifications.service.dto.NotificationCreationDTO;
import com.wso2.openbanking.accelerator.event.notifications.service.response.EventCreationResponse;
import com.wso2.openbanking.accelerator.event.notifications.service.util.EventNotificationServiceUtil;
import net.minidev.json.JSONObject;

/**
 * Handler class for persisting event notifications to the database.
 */
public class EventNotificationPersistenceServiceHandler {
    private static EventNotificationPersistenceServiceHandler instance =
            new EventNotificationPersistenceServiceHandler();
    private DefaultEventCreationServiceHandler defaultEventCreationServiceHandler;

    private EventNotificationPersistenceServiceHandler() {
        this.defaultEventCreationServiceHandler = EventNotificationServiceUtil.getDefaultEventCreationServiceHandler();
    }

    public static EventNotificationPersistenceServiceHandler getInstance() {
        return instance;
    }

    /**
     * This method is to persist authorization revoke event.
     *
     * @param clientId - client ID
     * @param resourceId - resource ID
     * @param notificationType - notification type
     * @param notificationInfo - notification info
     * @return EventCreationResponse
     */
    public EventCreationResponse persistRevokeEvent(String clientId,
                                              String resourceId,
                                              String notificationType, JSONObject notificationInfo) {
        NotificationCreationDTO notificationCreationDTO =
                new NotificationCreationDTO();
        notificationCreationDTO.setClientId(clientId);
        notificationCreationDTO.setResourceId(resourceId);
        notificationCreationDTO.setEventPayload(notificationType, notificationInfo);
        return defaultEventCreationServiceHandler.publishOBEvent(notificationCreationDTO);
    }
}
