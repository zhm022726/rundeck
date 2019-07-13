/*
 * Copyright 2019 Rundeck, Inc. (http://rundeck.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dtolabs.rundeck.server.plugins.services

import com.dtolabs.rundeck.core.plugins.PluggableProviderService
import com.dtolabs.rundeck.core.plugins.ServiceProviderLoader
import com.dtolabs.rundeck.plugins.ServiceNameConstants
import com.dtolabs.rundeck.plugins.webhook.WebhookEventPlugin
import org.rundeck.core.plugins.PluginProviderServices


class WebhookEventPluginProviderService implements PluginProviderServices {
    @Override
    def <T> boolean hasServiceFor(final Class<T> serviceType, final String serviceName) {
        return serviceType == WebhookEventPlugin.class && serviceName.equals(ServiceNameConstants.WebhookEvent)
    }

    @Override
    def <T> PluggableProviderService<T> getServiceProviderFor(
            final Class<T> serviceType,
            final String serviceName,
            final ServiceProviderLoader loader
    ) {
        if(serviceType == WebhookEventPlugin.class && ServiceNameConstants.WebhookEvent.equals(serviceName))
            return (PluggableProviderService<T>)new WebhookEventProviderService(loader)
        return null
    }
}