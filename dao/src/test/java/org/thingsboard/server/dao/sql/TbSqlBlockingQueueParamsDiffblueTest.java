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
package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder;

@ContextConfiguration(classes = {TbSqlBlockingQueueParamsBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TbSqlBlockingQueueParamsDiffblueTest {
  @Autowired private TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder;

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}, and {@link
   * TbSqlBlockingQueueParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParams#equals(Object)}
   *   <li>{@link TbSqlBlockingQueueParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams2 =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertEquals(tbSqlBlockingQueueParams, tbSqlBlockingQueueParams2);
    assertEquals(tbSqlBlockingQueueParams.hashCode(), tbSqlBlockingQueueParams2.hashCode());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}, and {@link
   * TbSqlBlockingQueueParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParams#equals(Object)}
   *   <li>{@link TbSqlBlockingQueueParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName(null)
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams2 =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName(null)
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertEquals(tbSqlBlockingQueueParams, tbSqlBlockingQueueParams2);
    assertEquals(tbSqlBlockingQueueParams.hashCode(), tbSqlBlockingQueueParams2.hashCode());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}, and {@link
   * TbSqlBlockingQueueParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParams#equals(Object)}
   *   <li>{@link TbSqlBlockingQueueParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix(null)
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams2 =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix(null)
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertEquals(tbSqlBlockingQueueParams, tbSqlBlockingQueueParams2);
    assertEquals(tbSqlBlockingQueueParams.hashCode(), tbSqlBlockingQueueParams2.hashCode());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}, and {@link
   * TbSqlBlockingQueueParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParams#equals(Object)}
   *   <li>{@link TbSqlBlockingQueueParams#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertEquals(tbSqlBlockingQueueParams, tbSqlBlockingQueueParams);
    int expectedHashCodeResult = tbSqlBlockingQueueParams.hashCode();
    assertEquals(expectedHashCodeResult, tbSqlBlockingQueueParams.hashCode());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(1)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertNotEquals(
        tbSqlBlockingQueueParams,
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(false)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertNotEquals(
        tbSqlBlockingQueueParams,
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Stats Name Prefix")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertNotEquals(
        tbSqlBlockingQueueParams,
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName(null)
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertNotEquals(
        tbSqlBlockingQueueParams,
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(3L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertNotEquals(
        tbSqlBlockingQueueParams,
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Log Name")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertNotEquals(
        tbSqlBlockingQueueParams,
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix(null)
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertNotEquals(
        tbSqlBlockingQueueParams,
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(1L)
            .withResponse(true)
            .build();

    // Act and Assert
    assertNotEquals(
        tbSqlBlockingQueueParams,
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(false)
            .build();

    // Act and Assert
    assertNotEquals(
        tbSqlBlockingQueueParams,
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build(),
        null);
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSqlBlockingQueueParams.equals(Object)",
    "int TbSqlBlockingQueueParams.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build(),
        "Different type to TbSqlBlockingQueueParams");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParams#toString()}
   *   <li>{@link TbSqlBlockingQueueParams#getBatchSize()}
   *   <li>{@link TbSqlBlockingQueueParams#getLogName()}
   *   <li>{@link TbSqlBlockingQueueParams#getMaxDelay()}
   *   <li>{@link TbSqlBlockingQueueParams#getStatsNamePrefix()}
   *   <li>{@link TbSqlBlockingQueueParams#getStatsPrintIntervalMs()}
   *   <li>{@link TbSqlBlockingQueueParams#isBatchSortEnabled()}
   *   <li>{@link TbSqlBlockingQueueParams#isWithResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int TbSqlBlockingQueueParams.getBatchSize()",
    "String TbSqlBlockingQueueParams.getLogName()",
    "long TbSqlBlockingQueueParams.getMaxDelay()",
    "String TbSqlBlockingQueueParams.getStatsNamePrefix()",
    "long TbSqlBlockingQueueParams.getStatsPrintIntervalMs()",
    "boolean TbSqlBlockingQueueParams.isBatchSortEnabled()",
    "boolean TbSqlBlockingQueueParams.isWithResponse()",
    "String TbSqlBlockingQueueParams.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    TbSqlBlockingQueueParams tbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Act
    String actualToStringResult = tbSqlBlockingQueueParams.toString();
    int actualBatchSize = tbSqlBlockingQueueParams.getBatchSize();
    String actualLogName = tbSqlBlockingQueueParams.getLogName();
    long actualMaxDelay = tbSqlBlockingQueueParams.getMaxDelay();
    String actualStatsNamePrefix = tbSqlBlockingQueueParams.getStatsNamePrefix();
    long actualStatsPrintIntervalMs = tbSqlBlockingQueueParams.getStatsPrintIntervalMs();
    boolean actualIsBatchSortEnabledResult = tbSqlBlockingQueueParams.isBatchSortEnabled();

    // Assert
    assertEquals("Log Name", actualLogName);
    assertEquals("Stats Name Prefix", actualStatsNamePrefix);
    assertEquals(
        "TbSqlBlockingQueueParams(logName=Log Name, batchSize=3, maxDelay=1, statsPrintIntervalMs=42,"
            + " statsNamePrefix=Stats Name Prefix, batchSortEnabled=true, withResponse=true)",
        actualToStringResult);
    assertEquals(1L, actualMaxDelay);
    assertEquals(3, actualBatchSize);
    assertEquals(42L, actualStatsPrintIntervalMs);
    assertTrue(actualIsBatchSortEnabledResult);
    assertTrue(tbSqlBlockingQueueParams.isWithResponse());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#TbSqlBlockingQueueParams(String, int, long, long, String,
   * boolean, boolean)}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueueParams#TbSqlBlockingQueueParams(String, int,
   * long, long, String, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSqlBlockingQueueParams.<init>(String, int, long, long, String, boolean, boolean)"
  })
  public void testNewTbSqlBlockingQueueParams() {
    // Arrange and Act
    TbSqlBlockingQueueParams actualTbSqlBlockingQueueParams =
        new TbSqlBlockingQueueParams("Log Name", 3, 1L, 42L, "Stats Name Prefix", true, true);

    // Assert
    assertEquals("Log Name", actualTbSqlBlockingQueueParams.getLogName());
    assertEquals("Stats Name Prefix", actualTbSqlBlockingQueueParams.getStatsNamePrefix());
    assertEquals(1L, actualTbSqlBlockingQueueParams.getMaxDelay());
    assertEquals(3, actualTbSqlBlockingQueueParams.getBatchSize());
    assertEquals(42L, actualTbSqlBlockingQueueParams.getStatsPrintIntervalMs());
    assertTrue(actualTbSqlBlockingQueueParams.isBatchSortEnabled());
    assertTrue(actualTbSqlBlockingQueueParams.isWithResponse());
  }

  /**
   * Test TbSqlBlockingQueueParamsBuilder {@link TbSqlBlockingQueueParamsBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#build()}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#batchSize(int)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#batchSortEnabled(boolean)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#logName(String)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#maxDelay(long)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#statsNamePrefix(String)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#statsPrintIntervalMs(long)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#withResponse(boolean)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSqlBlockingQueueParamsBuilder.<init>()",
    "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.batchSize(int)",
    "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.batchSortEnabled(boolean)",
    "TbSqlBlockingQueueParams TbSqlBlockingQueueParamsBuilder.build()",
    "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.logName(String)",
    "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.maxDelay(long)",
    "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.statsNamePrefix(String)",
    "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.statsPrintIntervalMs(long)",
    "String TbSqlBlockingQueueParamsBuilder.toString()",
    "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.withResponse(boolean)"
  })
  public void testTbSqlBlockingQueueParamsBuilderBuild() {
    // Arrange and Act
    TbSqlBlockingQueueParams actualTbSqlBlockingQueueParams =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    // Assert
    assertEquals("Log Name", actualTbSqlBlockingQueueParams.getLogName());
    assertEquals("Stats Name Prefix", actualTbSqlBlockingQueueParams.getStatsNamePrefix());
    assertEquals(1L, actualTbSqlBlockingQueueParams.getMaxDelay());
    assertEquals(3, actualTbSqlBlockingQueueParams.getBatchSize());
    assertEquals(42L, actualTbSqlBlockingQueueParams.getStatsPrintIntervalMs());
    assertTrue(actualTbSqlBlockingQueueParams.isBatchSortEnabled());
    assertTrue(actualTbSqlBlockingQueueParams.isWithResponse());
  }
}
