/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.vcloud.features;

import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.vcloud.filters.AddVCloudAuthorizationAndCookieToRequest;

/**
 * Provides access to Org functionality in vCloud
 * <p/>
 *
 * @deprecated  The async interface will be removed in jclouds 1.7.
 * @author Adrian Cole
 */
@Deprecated
@RequestFilters(AddVCloudAuthorizationAndCookieToRequest.class)
public interface OrgAsyncApi extends OrgAsyncClient {

}
