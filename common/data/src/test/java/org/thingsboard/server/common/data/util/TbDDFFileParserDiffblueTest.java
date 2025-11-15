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

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.leshan.core.model.InvalidDDFFileException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbDDFFileParserDiffblueTest {
  /**
   * Test {@link TbDDFFileParser#parse(InputStream, String)}.
   * <ul>
   *   <li>Then throw {@link InvalidDDFFileException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDDFFileParser#parse(InputStream, String)}
   */
  @Test
  @DisplayName("Test parse(InputStream, String); then throw InvalidDDFFileException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List TbDDFFileParser.parse(InputStream, String)"})
  void testParse_thenThrowInvalidDDFFileException() throws IOException, InvalidDDFFileException {
    // Arrange
    TbDDFFileParser tbDDFFileParser = new TbDDFFileParser();

    // Act and Assert
    assertThrows(InvalidDDFFileException.class,
        () -> tbDDFFileParser.parse(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Stream Name"));
  }
}
