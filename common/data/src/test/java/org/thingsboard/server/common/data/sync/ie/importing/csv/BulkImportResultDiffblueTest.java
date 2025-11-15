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
package org.thingsboard.server.common.data.sync.ie.importing.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class BulkImportResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportResult#equals(Object)}
   *   <li>{@link BulkImportResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(null);
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(null);

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(null);
    bulkImportResult2.setErrors(null);
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(null);

    // Act and Assert
    assertEquals(bulkImportResult, bulkImportResult2);
    int expectedHashCodeResult = bulkImportResult.hashCode();
    assertEquals(expectedHashCodeResult, bulkImportResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportResult#equals(Object)}
   *   <li>{@link BulkImportResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(new AtomicInteger(1));
    bulkImportResult.setErrors(new AtomicInteger(1));
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger(1));

    // Act and Assert
    assertEquals(bulkImportResult, bulkImportResult);
    int expectedHashCodeResult = bulkImportResult.hashCode();
    assertEquals(expectedHashCodeResult, bulkImportResult.hashCode());
  }

  /**
   * Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(new AtomicInteger(1));
    bulkImportResult.setErrors(new AtomicInteger(1));
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger(1));

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(new AtomicInteger(1));
    bulkImportResult2.setErrors(new AtomicInteger(1));
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(new AtomicInteger(1));

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(new AtomicInteger(1));
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger(1));

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(new AtomicInteger(1));
    bulkImportResult2.setErrors(new AtomicInteger(1));
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(new AtomicInteger(1));

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(new AtomicInteger(1));
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger(1));

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(null);
    bulkImportResult2.setErrors(new AtomicInteger(1));
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(new AtomicInteger(1));

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(new AtomicInteger(1));
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(null);

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(null);
    bulkImportResult2.setErrors(new AtomicInteger(1));
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(new AtomicInteger(1));

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(new AtomicInteger(1));
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(null);

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(null);
    bulkImportResult2.setErrors(new AtomicInteger(1));
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(null);

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(null);
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(null);

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(null);
    bulkImportResult2.setErrors(new AtomicInteger(1));
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(null);

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ArrayList<String> errorsList = new ArrayList<>();
    errorsList.add("foo");

    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(null);
    bulkImportResult.setErrorsList(errorsList);
    bulkImportResult.setUpdated(null);

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(null);
    bulkImportResult2.setErrors(null);
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(null);

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(new AtomicInteger(1));
    bulkImportResult.setErrors(new AtomicInteger(1));
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger(1));

    // Act and Assert
    assertNotEquals(bulkImportResult, null);
  }

  /**
   * Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(new AtomicInteger(1));
    bulkImportResult.setErrors(new AtomicInteger(1));
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger(1));

    // Act and Assert
    assertNotEquals(bulkImportResult, "Different type to BulkImportResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BulkImportResult}
   *   <li>{@link BulkImportResult#setCreated(AtomicInteger)}
   *   <li>{@link BulkImportResult#setErrors(AtomicInteger)}
   *   <li>{@link BulkImportResult#setErrorsList(Collection)}
   *   <li>{@link BulkImportResult#setUpdated(AtomicInteger)}
   *   <li>{@link BulkImportResult#toString()}
   *   <li>{@link BulkImportResult#getCreated()}
   *   <li>{@link BulkImportResult#getErrors()}
   *   <li>{@link BulkImportResult#getErrorsList()}
   *   <li>{@link BulkImportResult#getUpdated()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BulkImportResult<Object> actualBulkImportResult = new BulkImportResult<>();
    AtomicInteger created = new AtomicInteger(1);
    actualBulkImportResult.setCreated(created);
    AtomicInteger errors = new AtomicInteger(1);
    actualBulkImportResult.setErrors(errors);
    ArrayList<String> errorsList = new ArrayList<>();
    actualBulkImportResult.setErrorsList(errorsList);
    AtomicInteger updated = new AtomicInteger(1);
    actualBulkImportResult.setUpdated(updated);
    String actualToStringResult = actualBulkImportResult.toString();
    AtomicInteger actualCreated = actualBulkImportResult.getCreated();
    AtomicInteger actualErrors = actualBulkImportResult.getErrors();
    Collection<String> actualErrorsList = actualBulkImportResult.getErrorsList();

    // Assert that nothing has changed
    assertTrue(actualErrorsList instanceof List);
    assertEquals("BulkImportResult(created=1, updated=1, errors=1, errorsList=[])", actualToStringResult);
    assertSame(errorsList, actualErrorsList);
    assertSame(created, actualCreated);
    assertSame(errors, actualErrors);
    assertSame(updated, actualBulkImportResult.getUpdated());
  }
}
