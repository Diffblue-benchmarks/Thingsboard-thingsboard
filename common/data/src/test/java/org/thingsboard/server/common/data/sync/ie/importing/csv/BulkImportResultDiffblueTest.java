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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkImportResultDiffblueTest {
  /**
   * Test {@link BulkImportResult#equals(Object)}, and {@link BulkImportResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BulkImportResult#equals(Object)}
   *   <li>{@link BulkImportResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
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
    assertEquals(bulkImportResult.hashCode(), bulkImportResult2.hashCode());
  }

  /**
   * Test {@link BulkImportResult#equals(Object)}, and {@link BulkImportResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BulkImportResult#equals(Object)}
   *   <li>{@link BulkImportResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(new AtomicInteger());
    bulkImportResult.setErrors(new AtomicInteger());
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger());

    // Act and Assert
    assertEquals(bulkImportResult, bulkImportResult);
    int expectedHashCodeResult = bulkImportResult.hashCode();
    assertEquals(expectedHashCodeResult, bulkImportResult.hashCode());
  }

  /**
   * Test {@link BulkImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(new AtomicInteger());
    bulkImportResult.setErrors(new AtomicInteger());
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger());

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(new AtomicInteger());
    bulkImportResult2.setErrors(new AtomicInteger());
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(new AtomicInteger());

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Test {@link BulkImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(new AtomicInteger());
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger());

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(new AtomicInteger());
    bulkImportResult2.setErrors(new AtomicInteger());
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(new AtomicInteger());

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Test {@link BulkImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(new AtomicInteger());
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger());

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(null);
    bulkImportResult2.setErrors(new AtomicInteger());
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(new AtomicInteger());

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Test {@link BulkImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(new AtomicInteger());
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(null);

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(null);
    bulkImportResult2.setErrors(new AtomicInteger());
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(new AtomicInteger());

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Test {@link BulkImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(new AtomicInteger());
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(null);

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(null);
    bulkImportResult2.setErrors(new AtomicInteger());
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(null);

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Test {@link BulkImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(null);
    bulkImportResult.setErrors(null);
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(null);

    BulkImportResult<Object> bulkImportResult2 = new BulkImportResult<>();
    bulkImportResult2.setCreated(null);
    bulkImportResult2.setErrors(new AtomicInteger());
    bulkImportResult2.setErrorsList(new ArrayList<>());
    bulkImportResult2.setUpdated(null);

    // Act and Assert
    assertNotEquals(bulkImportResult, bulkImportResult2);
  }

  /**
   * Test {@link BulkImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
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
   * Test {@link BulkImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(new AtomicInteger());
    bulkImportResult.setErrors(new AtomicInteger());
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger());

    // Act and Assert
    assertNotEquals(bulkImportResult, null);
  }

  /**
   * Test {@link BulkImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkImportResult.equals(Object)", "int BulkImportResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BulkImportResult<Object> bulkImportResult = new BulkImportResult<>();
    bulkImportResult.setCreated(new AtomicInteger());
    bulkImportResult.setErrors(new AtomicInteger());
    bulkImportResult.setErrorsList(new ArrayList<>());
    bulkImportResult.setUpdated(new AtomicInteger());

    // Act and Assert
    assertNotEquals(bulkImportResult, "Different type to BulkImportResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BulkImportResult.<init>()",
    "AtomicInteger BulkImportResult.getCreated()",
    "AtomicInteger BulkImportResult.getErrors()",
    "Collection BulkImportResult.getErrorsList()",
    "AtomicInteger BulkImportResult.getUpdated()",
    "void BulkImportResult.setCreated(AtomicInteger)",
    "void BulkImportResult.setErrors(AtomicInteger)",
    "void BulkImportResult.setErrorsList(Collection)",
    "void BulkImportResult.setUpdated(AtomicInteger)",
    "String BulkImportResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BulkImportResult<Object> actualBulkImportResult = new BulkImportResult<>();
    AtomicInteger created = new AtomicInteger();
    actualBulkImportResult.setCreated(created);
    AtomicInteger errors = new AtomicInteger();
    actualBulkImportResult.setErrors(errors);
    ArrayList<String> errorsList = new ArrayList<>();
    actualBulkImportResult.setErrorsList(errorsList);
    AtomicInteger updated = new AtomicInteger();
    actualBulkImportResult.setUpdated(updated);
    String actualToStringResult = actualBulkImportResult.toString();
    AtomicInteger actualCreated = actualBulkImportResult.getCreated();
    AtomicInteger actualErrors = actualBulkImportResult.getErrors();
    Collection<String> actualErrorsList = actualBulkImportResult.getErrorsList();

    // Assert
    assertTrue(actualErrorsList instanceof List);
    assertEquals(
        "BulkImportResult(created=0, updated=0, errors=0, errorsList=[])", actualToStringResult);
    assertSame(errorsList, actualErrorsList);
    assertSame(created, actualCreated);
    assertSame(errors, actualErrors);
    assertSame(updated, actualBulkImportResult.getUpdated());
  }
}
