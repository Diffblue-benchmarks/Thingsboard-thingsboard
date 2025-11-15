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
import static org.mockito.Mockito.mock;
import javax.xml.validation.SchemaFactory;
import org.apache.xerces.jaxp.validation.XMLSchemaFactory;
import org.eclipse.leshan.core.LwM2m;
import org.junit.jupiter.api.Test;

class TbDefaultDDFFileValidatorDiffblueTest {
  /**
   * Method under test: {@link TbDefaultDDFFileValidator#createSchemaFactory()}
   */
  @Test
  void testCreateSchemaFactory() {
    // Arrange and Act
    SchemaFactory actualCreateSchemaFactoryResult = (new TbDefaultDDFFileValidator()).createSchemaFactory();

    // Assert
    assertTrue(actualCreateSchemaFactoryResult instanceof XMLSchemaFactory);
    assertNull(actualCreateSchemaFactoryResult.getResourceResolver());
    assertNull(actualCreateSchemaFactoryResult.getErrorHandler());
  }

  /**
   * Method under test: {@link TbDefaultDDFFileValidator#createSchemaFactory()}
   */
  @Test
  void testCreateSchemaFactory2() {
    // Arrange and Act
    SchemaFactory actualCreateSchemaFactoryResult = (new TbDefaultDDFFileValidator()).createSchemaFactory();

    // Assert
    assertTrue(actualCreateSchemaFactoryResult instanceof XMLSchemaFactory);
    assertNull(actualCreateSchemaFactoryResult.getResourceResolver());
    assertNull(actualCreateSchemaFactoryResult.getErrorHandler());
  }

  /**
   * Method under test:
   * {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2m.LwM2mVersion)}
   */
  @Test
  void testNewTbDefaultDDFFileValidator() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new TbDefaultDDFFileValidator(mock(LwM2m.LwM2mVersion.class)));
    assertThrows(IllegalStateException.class, () -> new TbDefaultDDFFileValidator(mock(LwM2m.LwM2mVersion.class)));
  }
}
