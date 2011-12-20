/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.openstack.swift.blobstore.integration;

import org.jclouds.blobstore.domain.Blob;
import org.jclouds.blobstore.integration.internal.BaseBlobIntegrationTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 
 * @author James Murty
 * @author Adrian Cole
 */
@Test(groups = "live")
public class SwiftBlobIntegrationLiveTest extends BaseBlobIntegrationTest {

   @Override
   @Test(enabled = false)
   public void testGetTwoRanges() {
      // not supported in swift
   }


   @Override
   protected void checkContentDisposition(Blob blob, String contentDisposition) {
     // This works for Swift Server 1.4.4/SWauth 1.0.3 but was null in previous versions.
     // TODO: Better testing for the different versions.
     super.checkContentDisposition(blob,contentDisposition);
   }

   // not supported in swift
   @Override
   protected void checkContentLanguage(Blob blob, String contentLanguage) {
      assert blob.getPayload().getContentMetadata().getContentLanguage() == null;
      assert blob.getMetadata().getContentMetadata().getContentLanguage() == null;
   }
   
   // swift doesn't support quotes
   @Override
   @DataProvider(name = "delete")
   public Object[][] createData() {
      return new Object[][] { { "normal" }, { "sp ace" }, { "qu?stion" }, { "unic₪de" }, { "path/foo" }, { "colon:" },
               { "asteri*k" }, { "{great<r}" }, { "lesst>en" }, { "p|pe" } };
   }
}
