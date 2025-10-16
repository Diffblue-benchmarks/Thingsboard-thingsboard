/**
 * Copyright © 2016-2024 The Thingsboard Authors
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
package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.xml.validation.SchemaFactory;
import org.apache.xerces.jaxp.validation.XMLSchemaFactory;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.LwM2mVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbDefaultDDFFileValidatorDiffblueTest {
  /**
   * Test {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2mVersion)}.
   *
   * <ul>
   *   <li>When {@code 421.0}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2mVersion)}
   */
  @Test
  @DisplayName(
      "Test new TbDefaultDDFFileValidator(LwM2mVersion); when '421.0'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDefaultDDFFileValidator.<init>(LwM2mVersion)"})
  void testNewTbDefaultDDFFileValidator_when4210_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new TbDefaultDDFFileValidator(LwM2mVersion.get("421.0")));
  }

  /**
   * Test {@link TbDefaultDDFFileValidator#createSchemaFactory()}.
   *
   * <p>Method under test: {@link TbDefaultDDFFileValidator#createSchemaFactory()}
   */
  @Test
  @DisplayName("Test createSchemaFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaFactory TbDefaultDDFFileValidator.createSchemaFactory()"})
  void testCreateSchemaFactory() {
    // Arrange and Act
    SchemaFactory actualCreateSchemaFactoryResult =
        new TbDefaultDDFFileValidator().createSchemaFactory();

    // Assert
    assertTrue(actualCreateSchemaFactoryResult instanceof XMLSchemaFactory);
    assertNull(actualCreateSchemaFactoryResult.getResourceResolver());
    assertNull(actualCreateSchemaFactoryResult.getErrorHandler());
  }
}
