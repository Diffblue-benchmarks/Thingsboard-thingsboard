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
package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SqlPartitionDiffblueTest {
  /**
   * Test {@link SqlPartition#SqlPartition(String, long, long, String)}.
   *
   * <p>Method under test: {@link SqlPartition#SqlPartition(String, long, long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlPartition.<init>(String, long, long, String)"})
  public void testNewSqlPartition() {
    // Arrange and Act
    SqlPartition actualSqlPartition = new SqlPartition("Table", 1L, 1L, "2020-03-01");

    // Assert
    assertEquals("2020-03-01", actualSqlPartition.getPartitionDate());
    assertEquals(
        "CREATE TABLE IF NOT EXISTS Table_2020-03-01 PARTITION OF Table FOR VALUES FROM (1) TO (1)",
        actualSqlPartition.getQuery());
    assertEquals(1L, actualSqlPartition.getEnd());
    assertEquals(1L, actualSqlPartition.getStart());
  }

  /**
   * Test {@link SqlPartition#equals(Object)}, and {@link SqlPartition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SqlPartition#equals(Object)}
   *   <li>{@link SqlPartition#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SqlPartition sqlPartition = new SqlPartition("Table", 1L, 1L, "2020-03-01");
    SqlPartition sqlPartition2 = new SqlPartition("Table", 1L, 1L, "2020-03-01");

    // Act and Assert
    assertEquals(sqlPartition, sqlPartition2);
    assertEquals(sqlPartition.hashCode(), sqlPartition2.hashCode());
  }

  /**
   * Test {@link SqlPartition#equals(Object)}, and {@link SqlPartition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SqlPartition#equals(Object)}
   *   <li>{@link SqlPartition#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SqlPartition sqlPartition = new SqlPartition("Table", 1L, 1L, null);
    SqlPartition sqlPartition2 = new SqlPartition("Table", 1L, 1L, null);

    // Act and Assert
    assertEquals(sqlPartition, sqlPartition2);
    assertEquals(sqlPartition.hashCode(), sqlPartition2.hashCode());
  }

  /**
   * Test {@link SqlPartition#equals(Object)}, and {@link SqlPartition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SqlPartition#equals(Object)}
   *   <li>{@link SqlPartition#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SqlPartition sqlPartition = new SqlPartition("Table", 1L, 1L, "2020-03-01");

    // Act and Assert
    assertEquals(sqlPartition, sqlPartition);
    int expectedHashCodeResult = sqlPartition.hashCode();
    assertEquals(expectedHashCodeResult, sqlPartition.hashCode());
  }

  /**
   * Test {@link SqlPartition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartition#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SqlPartition sqlPartition = new SqlPartition("Table", 3L, 1L, "2020-03-01");

    // Act and Assert
    assertNotEquals(sqlPartition, new SqlPartition("Table", 1L, 1L, "2020-03-01"));
  }

  /**
   * Test {@link SqlPartition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartition#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SqlPartition sqlPartition = new SqlPartition("Table", 1L, 3L, "2020-03-01");

    // Act and Assert
    assertNotEquals(sqlPartition, new SqlPartition("Table", 1L, 1L, "2020-03-01"));
  }

  /**
   * Test {@link SqlPartition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartition#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SqlPartition sqlPartition = new SqlPartition("Table", 1L, 1L, "2020/03/01");

    // Act and Assert
    assertNotEquals(sqlPartition, new SqlPartition("Table", 1L, 1L, "2020-03-01"));
  }

  /**
   * Test {@link SqlPartition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartition#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SqlPartition sqlPartition = new SqlPartition("Table", 1L, 1L, null);

    // Act and Assert
    assertNotEquals(sqlPartition, new SqlPartition("Table", 1L, 1L, "2020-03-01"));
  }

  /**
   * Test {@link SqlPartition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartition#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SqlPartition sqlPartition = new SqlPartition("Table", 1L, 1L, "2020-03-01");
    sqlPartition.setQuery("2020-03-01");

    // Act and Assert
    assertNotEquals(sqlPartition, new SqlPartition("Table", 1L, 1L, "2020-03-01"));
  }

  /**
   * Test {@link SqlPartition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartition#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SqlPartition sqlPartition = new SqlPartition("Table", 1L, 1L, "2020-03-01");
    sqlPartition.setQuery(null);

    // Act and Assert
    assertNotEquals(sqlPartition, new SqlPartition("Table", 1L, 1L, "2020-03-01"));
  }

  /**
   * Test {@link SqlPartition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartition#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SqlPartition("Table", 1L, 1L, "2020-03-01"), null);
  }

  /**
   * Test {@link SqlPartition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartition#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlPartition.equals(Object)", "int SqlPartition.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new SqlPartition("Table", 1L, 1L, "2020-03-01"), "Different type to SqlPartition");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SqlPartition#setEnd(long)}
   *   <li>{@link SqlPartition#setPartitionDate(String)}
   *   <li>{@link SqlPartition#setQuery(String)}
   *   <li>{@link SqlPartition#setStart(long)}
   *   <li>{@link SqlPartition#toString()}
   *   <li>{@link SqlPartition#getEnd()}
   *   <li>{@link SqlPartition#getPartitionDate()}
   *   <li>{@link SqlPartition#getQuery()}
   *   <li>{@link SqlPartition#getStart()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SqlPartition.getEnd()",
    "String SqlPartition.getPartitionDate()",
    "String SqlPartition.getQuery()",
    "long SqlPartition.getStart()",
    "void SqlPartition.setEnd(long)",
    "void SqlPartition.setPartitionDate(String)",
    "void SqlPartition.setQuery(String)",
    "void SqlPartition.setStart(long)",
    "String SqlPartition.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    SqlPartition sqlPartition = new SqlPartition("Table", 1L, 1L, "2020-03-01");

    // Act
    sqlPartition.setEnd(1L);
    sqlPartition.setPartitionDate("2020-03-01");
    sqlPartition.setQuery("Query");
    sqlPartition.setStart(1L);
    String actualToStringResult = sqlPartition.toString();
    long actualEnd = sqlPartition.getEnd();
    String actualPartitionDate = sqlPartition.getPartitionDate();
    String actualQuery = sqlPartition.getQuery();

    // Assert
    assertEquals("2020-03-01", actualPartitionDate);
    assertEquals("Query", actualQuery);
    assertEquals(
        "SqlPartition(start=1, end=1, partitionDate=2020-03-01, query=Query)",
        actualToStringResult);
    assertEquals(1L, actualEnd);
    assertEquals(1L, sqlPartition.getStart());
  }
}
