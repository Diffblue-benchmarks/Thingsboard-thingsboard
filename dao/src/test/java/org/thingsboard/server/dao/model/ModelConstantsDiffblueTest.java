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
package org.thingsboard.server.dao.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.kv.Aggregation;

public class ModelConstantsDiffblueTest {
  /**
   * Test {@link ModelConstants#min(String)}.
   *
   * <p>Method under test: {@link ModelConstants#min(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ModelConstants.min(String)"})
  public void testMin() {
    // Arrange, Act and Assert
    assertEquals("min(foo)", ModelConstants.min("foo"));
  }

  /**
   * Test {@link ModelConstants#max(String)}.
   *
   * <p>Method under test: {@link ModelConstants#max(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ModelConstants.max(String)"})
  public void testMax() {
    // Arrange, Act and Assert
    assertEquals("max(foo)", ModelConstants.max("foo"));
  }

  /**
   * Test {@link ModelConstants#sum(String)}.
   *
   * <p>Method under test: {@link ModelConstants#sum(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ModelConstants.sum(String)"})
  public void testSum() {
    // Arrange, Act and Assert
    assertEquals("sum(foo)", ModelConstants.sum("foo"));
  }

  /**
   * Test {@link ModelConstants#count(String)}.
   *
   * <p>Method under test: {@link ModelConstants#count(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ModelConstants.count(String)"})
  public void testCount() {
    // Arrange, Act and Assert
    assertEquals("count(foo)", ModelConstants.count("foo"));
  }

  /**
   * Test {@link ModelConstants#getFetchColumnNames(Aggregation)}.
   *
   * <p>Method under test: {@link ModelConstants#getFetchColumnNames(Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ModelConstants.getFetchColumnNames(Aggregation)"})
  public void testGetFetchColumnNames() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {
          ModelConstants.LONG_VALUE_COLUMN,
          ModelConstants.DOUBLE_VALUE_COLUMN,
          ModelConstants.BOOLEAN_VALUE_COLUMN,
          ModelConstants.STRING_VALUE_COLUMN,
          ModelConstants.JSON_VALUE_COLUMN,
          ModelConstants.ADMIN_SETTINGS_KEY_PROPERTY,
          ModelConstants.TS_COLUMN
        },
        ModelConstants.getFetchColumnNames(Aggregation.NONE));
  }

  /**
   * Test {@link ModelConstants#getFetchColumnNames(Aggregation)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   * </ul>
   *
   * <p>Method under test: {@link ModelConstants#getFetchColumnNames(Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ModelConstants.getFetchColumnNames(Aggregation)"})
  public void testGetFetchColumnNames_whenAvg() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {
          "count(long_v)",
          "count(dbl_v)",
          "count(bool_v)",
          "count(str_v)",
          "count(json_v)",
          "max(ts)",
          "sum(long_v)",
          "sum(dbl_v)"
        },
        ModelConstants.getFetchColumnNames(Aggregation.AVG));
  }

  /**
   * Test {@link ModelConstants#getFetchColumnNames(Aggregation)}.
   *
   * <ul>
   *   <li>When {@code COUNT}.
   * </ul>
   *
   * <p>Method under test: {@link ModelConstants#getFetchColumnNames(Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ModelConstants.getFetchColumnNames(Aggregation)"})
  public void testGetFetchColumnNames_whenCount() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {
          "count(long_v)",
          "count(dbl_v)",
          "count(bool_v)",
          "count(str_v)",
          "count(json_v)",
          "max(ts)"
        },
        ModelConstants.getFetchColumnNames(Aggregation.COUNT));
  }

  /**
   * Test {@link ModelConstants#getFetchColumnNames(Aggregation)}.
   *
   * <ul>
   *   <li>When {@code MAX}.
   *   <li>Then return ninth element is {@code max(bool_v)}.
   * </ul>
   *
   * <p>Method under test: {@link ModelConstants#getFetchColumnNames(Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ModelConstants.getFetchColumnNames(Aggregation)"})
  public void testGetFetchColumnNames_whenMax_thenReturnNinthElementIsMaxBoolV() {
    // Arrange and Act
    String[] actualFetchColumnNames = ModelConstants.getFetchColumnNames(Aggregation.MAX);

    // Assert
    assertEquals("max(bool_v)", actualFetchColumnNames[8]);
    assertEquals("max(dbl_v)", actualFetchColumnNames[7]);
    assertEquals("max(json_v)", actualFetchColumnNames[10]);
    assertEquals("max(long_v)", actualFetchColumnNames[6]);
    assertEquals("max(str_v)", actualFetchColumnNames[9]);
    assertEquals(11, actualFetchColumnNames.length);
  }

  /**
   * Test {@link ModelConstants#getFetchColumnNames(Aggregation)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return ninth element is {@code min(bool_v)}.
   * </ul>
   *
   * <p>Method under test: {@link ModelConstants#getFetchColumnNames(Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ModelConstants.getFetchColumnNames(Aggregation)"})
  public void testGetFetchColumnNames_whenMin_thenReturnNinthElementIsMinBoolV() {
    // Arrange and Act
    String[] actualFetchColumnNames = ModelConstants.getFetchColumnNames(Aggregation.MIN);

    // Assert
    assertEquals("min(bool_v)", actualFetchColumnNames[8]);
    assertEquals("min(dbl_v)", actualFetchColumnNames[7]);
    assertEquals("min(json_v)", actualFetchColumnNames[10]);
    assertEquals("min(long_v)", actualFetchColumnNames[6]);
    assertEquals("min(str_v)", actualFetchColumnNames[9]);
    assertEquals(11, actualFetchColumnNames.length);
  }

  /**
   * Test {@link ModelConstants#getFetchColumnNames(Aggregation)}.
   *
   * <ul>
   *   <li>When {@code SUM}.
   * </ul>
   *
   * <p>Method under test: {@link ModelConstants#getFetchColumnNames(Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ModelConstants.getFetchColumnNames(Aggregation)"})
  public void testGetFetchColumnNames_whenSum() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {
          "count(long_v)",
          "count(dbl_v)",
          "count(bool_v)",
          "count(str_v)",
          "count(json_v)",
          "max(ts)",
          "sum(long_v)",
          "sum(dbl_v)"
        },
        ModelConstants.getFetchColumnNames(Aggregation.SUM));
  }
}
