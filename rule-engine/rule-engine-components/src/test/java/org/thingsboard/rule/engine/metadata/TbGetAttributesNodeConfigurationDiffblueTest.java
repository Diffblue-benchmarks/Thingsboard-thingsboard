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
package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.data.DeviceRelationsQuery;
import org.thingsboard.rule.engine.util.TbMsgSource;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class TbGetAttributesNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGetAttributesNodeConfiguration#defaultConfiguration()}.
   *
   * <ul>
   *   <li>Then return FetchTo is {@code METADATA}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); then return FetchTo is 'METADATA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetAttributesNodeConfiguration TbGetAttributesNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration_thenReturnFetchToIsMetadata() {
    // Arrange and Act
    TbGetAttributesNodeConfiguration actualDefaultConfigurationResult =
        new TbGetAttributesNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals(TbMsgSource.METADATA, actualDefaultConfigurationResult.getFetchTo());
    assertFalse(actualDefaultConfigurationResult.isGetLatestValueWithTs());
    List<String> clientAttributeNames = actualDefaultConfigurationResult.getClientAttributeNames();
    assertTrue(clientAttributeNames.isEmpty());
    assertTrue(actualDefaultConfigurationResult.isTellFailureIfAbsent());
    assertSame(clientAttributeNames, actualDefaultConfigurationResult.getLatestTsKeyNames());
    assertSame(clientAttributeNames, actualDefaultConfigurationResult.getServerAttributeNames());
    assertSame(clientAttributeNames, actualDefaultConfigurationResult.getSharedAttributeNames());
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#defaultConfiguration()}.
   *
   * <ul>
   *   <li>Then return {@link TbGetDeviceAttrNodeConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); then return TbGetDeviceAttrNodeConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetAttributesNodeConfiguration TbGetAttributesNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration_thenReturnTbGetDeviceAttrNodeConfiguration() {
    // Arrange and Act
    TbGetDeviceAttrNodeConfiguration actualDefaultConfigurationResult =
        new TbGetDeviceAttrNodeConfiguration().defaultConfiguration();

    // Assert
    assertTrue(actualDefaultConfigurationResult instanceof TbGetDeviceAttrNodeConfiguration);
    DeviceRelationsQuery deviceRelationsQuery =
        ((TbGetDeviceAttrNodeConfiguration) actualDefaultConfigurationResult)
            .getDeviceRelationsQuery();
    assertEquals("Contains", deviceRelationsQuery.getRelationType());
    List<String> deviceTypes = deviceRelationsQuery.getDeviceTypes();
    assertEquals(1, deviceTypes.size());
    assertEquals("default", deviceTypes.get(0));
    assertEquals(1, deviceRelationsQuery.getMaxLevel());
    assertEquals(EntitySearchDirection.FROM, deviceRelationsQuery.getDirection());
    assertFalse(deviceRelationsQuery.isFetchLastLevelOnly());
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}, and {@link
   * TbGetAttributesNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetAttributesNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetAttributesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration2 =
        new TbGetAttributesNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetAttributesNodeConfiguration, tbGetAttributesNodeConfiguration2);
    assertEquals(
        tbGetAttributesNodeConfiguration.hashCode(), tbGetAttributesNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}, and {@link
   * TbGetAttributesNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetAttributesNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetAttributesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setLatestTsKeyNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setServerAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setSharedAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setClientAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setGetLatestValueWithTs(true);
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.getLatestTsKeyNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getServerAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getSharedAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(false);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
    assertNotEquals(
        tbGetAttributesNodeConfiguration.hashCode(), tbGetDeviceAttrNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}, and {@link
   * TbGetAttributesNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetAttributesNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetAttributesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetAttributesNodeConfiguration, tbGetAttributesNodeConfiguration);
    int expectedHashCodeResult = tbGetAttributesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetAttributesNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        new TbGetDeviceAttrNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbGetDeviceAttrNodeConfiguration, new TbGetAttributesNodeConfiguration());
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, new TbGetDeviceAttrNodeConfiguration());
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(false);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setGetLatestValueWithTs(true);
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(false);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setClientAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setGetLatestValueWithTs(true);
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.getSharedAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(false);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ArrayList<String> clientAttributeNames = new ArrayList<>();
    clientAttributeNames.add("foo");

    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setClientAttributeNames(clientAttributeNames);
    tbGetAttributesNodeConfiguration.setGetLatestValueWithTs(true);
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.getSharedAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(false);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setSharedAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setClientAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setGetLatestValueWithTs(true);
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.getServerAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getSharedAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(false);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ArrayList<String> sharedAttributeNames = new ArrayList<>();
    sharedAttributeNames.add("foo");

    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setSharedAttributeNames(sharedAttributeNames);
    tbGetAttributesNodeConfiguration.setClientAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setGetLatestValueWithTs(true);
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.getServerAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getSharedAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(false);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setServerAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setSharedAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setClientAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setGetLatestValueWithTs(true);
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.getLatestTsKeyNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getServerAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getSharedAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(false);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ArrayList<String> serverAttributeNames = new ArrayList<>();
    serverAttributeNames.add("foo");

    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setServerAttributeNames(serverAttributeNames);
    tbGetAttributesNodeConfiguration.setSharedAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setClientAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setGetLatestValueWithTs(true);
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.getLatestTsKeyNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getServerAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getSharedAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(false);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ArrayList<String> latestTsKeyNames = new ArrayList<>();
    latestTsKeyNames.add("foo");

    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    tbGetAttributesNodeConfiguration.setLatestTsKeyNames(latestTsKeyNames);
    tbGetAttributesNodeConfiguration.setServerAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setSharedAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setClientAttributeNames(new ArrayList<>());
    tbGetAttributesNodeConfiguration.setGetLatestValueWithTs(true);
    tbGetAttributesNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        mock(TbGetDeviceAttrNodeConfiguration.class);
    when(tbGetDeviceAttrNodeConfiguration.getLatestTsKeyNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getServerAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getSharedAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs()).thenReturn(true);
    when(tbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent()).thenReturn(false);
    when(tbGetDeviceAttrNodeConfiguration.getClientAttributeNames()).thenReturn(new ArrayList<>());
    when(tbGetDeviceAttrNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetDeviceAttrNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetAttributesNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetAttributesNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGetAttributesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetAttributesNodeConfiguration.equals(Object)",
    "int TbGetAttributesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbGetAttributesNodeConfiguration(),
        "Different type to TbGetAttributesNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetAttributesNodeConfiguration}
   *   <li>{@link TbGetAttributesNodeConfiguration#setClientAttributeNames(List)}
   *   <li>{@link TbGetAttributesNodeConfiguration#setGetLatestValueWithTs(boolean)}
   *   <li>{@link TbGetAttributesNodeConfiguration#setLatestTsKeyNames(List)}
   *   <li>{@link TbGetAttributesNodeConfiguration#setServerAttributeNames(List)}
   *   <li>{@link TbGetAttributesNodeConfiguration#setSharedAttributeNames(List)}
   *   <li>{@link TbGetAttributesNodeConfiguration#setTellFailureIfAbsent(boolean)}
   *   <li>{@link TbGetAttributesNodeConfiguration#toString()}
   *   <li>{@link TbGetAttributesNodeConfiguration#getClientAttributeNames()}
   *   <li>{@link TbGetAttributesNodeConfiguration#getLatestTsKeyNames()}
   *   <li>{@link TbGetAttributesNodeConfiguration#getServerAttributeNames()}
   *   <li>{@link TbGetAttributesNodeConfiguration#getSharedAttributeNames()}
   *   <li>{@link TbGetAttributesNodeConfiguration#isGetLatestValueWithTs()}
   *   <li>{@link TbGetAttributesNodeConfiguration#isTellFailureIfAbsent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbGetAttributesNodeConfiguration.<init>()",
    "List TbGetAttributesNodeConfiguration.getClientAttributeNames()",
    "List TbGetAttributesNodeConfiguration.getLatestTsKeyNames()",
    "List TbGetAttributesNodeConfiguration.getServerAttributeNames()",
    "List TbGetAttributesNodeConfiguration.getSharedAttributeNames()",
    "boolean TbGetAttributesNodeConfiguration.isGetLatestValueWithTs()",
    "boolean TbGetAttributesNodeConfiguration.isTellFailureIfAbsent()",
    "void TbGetAttributesNodeConfiguration.setClientAttributeNames(List)",
    "void TbGetAttributesNodeConfiguration.setGetLatestValueWithTs(boolean)",
    "void TbGetAttributesNodeConfiguration.setLatestTsKeyNames(List)",
    "void TbGetAttributesNodeConfiguration.setServerAttributeNames(List)",
    "void TbGetAttributesNodeConfiguration.setSharedAttributeNames(List)",
    "void TbGetAttributesNodeConfiguration.setTellFailureIfAbsent(boolean)",
    "String TbGetAttributesNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbGetAttributesNodeConfiguration actualTbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();
    ArrayList<String> clientAttributeNames = new ArrayList<>();
    actualTbGetAttributesNodeConfiguration.setClientAttributeNames(clientAttributeNames);
    actualTbGetAttributesNodeConfiguration.setGetLatestValueWithTs(true);
    ArrayList<String> latestTsKeyNames = new ArrayList<>();
    actualTbGetAttributesNodeConfiguration.setLatestTsKeyNames(latestTsKeyNames);
    ArrayList<String> serverAttributeNames = new ArrayList<>();
    actualTbGetAttributesNodeConfiguration.setServerAttributeNames(serverAttributeNames);
    ArrayList<String> sharedAttributeNames = new ArrayList<>();
    actualTbGetAttributesNodeConfiguration.setSharedAttributeNames(sharedAttributeNames);
    actualTbGetAttributesNodeConfiguration.setTellFailureIfAbsent(true);
    String actualToStringResult = actualTbGetAttributesNodeConfiguration.toString();
    List<String> actualClientAttributeNames =
        actualTbGetAttributesNodeConfiguration.getClientAttributeNames();
    List<String> actualLatestTsKeyNames =
        actualTbGetAttributesNodeConfiguration.getLatestTsKeyNames();
    List<String> actualServerAttributeNames =
        actualTbGetAttributesNodeConfiguration.getServerAttributeNames();
    List<String> actualSharedAttributeNames =
        actualTbGetAttributesNodeConfiguration.getSharedAttributeNames();
    boolean actualIsGetLatestValueWithTsResult =
        actualTbGetAttributesNodeConfiguration.isGetLatestValueWithTs();
    boolean actualIsTellFailureIfAbsentResult =
        actualTbGetAttributesNodeConfiguration.isTellFailureIfAbsent();

    // Assert
    assertEquals(
        "TbGetAttributesNodeConfiguration(clientAttributeNames=[], sharedAttributeNames=[], serverAttributeNames=[],"
            + " latestTsKeyNames=[], tellFailureIfAbsent=true, getLatestValueWithTs=true)",
        actualToStringResult);
    assertNull(actualTbGetAttributesNodeConfiguration.getFetchTo());
    assertTrue(actualClientAttributeNames.isEmpty());
    assertTrue(actualLatestTsKeyNames.isEmpty());
    assertTrue(actualServerAttributeNames.isEmpty());
    assertTrue(actualSharedAttributeNames.isEmpty());
    assertTrue(actualIsGetLatestValueWithTsResult);
    assertTrue(actualIsTellFailureIfAbsentResult);
    assertSame(clientAttributeNames, actualClientAttributeNames);
    assertSame(latestTsKeyNames, actualLatestTsKeyNames);
    assertSame(serverAttributeNames, actualServerAttributeNames);
    assertSame(sharedAttributeNames, actualSharedAttributeNames);
  }
}
