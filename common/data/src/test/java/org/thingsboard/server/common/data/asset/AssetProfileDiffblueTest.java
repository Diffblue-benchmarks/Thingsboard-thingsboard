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
package org.thingsboard.server.common.data.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;

class AssetProfileDiffblueTest {
  /**
   * Method under test: {@link AssetProfile#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new AssetProfile()).getId());
  }

  /**
   * Method under test: {@link AssetProfile#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AssetProfile()).getCreatedTime());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfile#equals(Object)}
   *   <li>{@link AssetProfile#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    AssetProfile assetProfile2 = new AssetProfile();

    // Act and Assert
    assertEquals(assetProfile, assetProfile2);
    int expectedHashCodeResult = assetProfile.hashCode();
    assertEquals(expectedHashCodeResult, assetProfile2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfile#equals(Object)}
   *   <li>{@link AssetProfile#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertEquals(assetProfile, assetProfile);
    int expectedHashCodeResult = assetProfile.hashCode();
    assertEquals(expectedHashCodeResult, assetProfile.hashCode());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfile(), 1);
    assertNotEquals(new AssetProfile(), mock(Asset.class));
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setName("Name");

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setImage("Image");

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefault(true);

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefaultRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefaultQueueName("Default Queue Name");

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefaultEdgeRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setName("Name");

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setImage("Image");

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setDefaultRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setDefaultQueueName("Default Queue Name");

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setDefaultEdgeRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfile(), null);
  }

  /**
   * Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfile(), "Different type to AssetProfile");
  }

  /**
   * Method under test: {@link AssetProfile#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new AssetProfile()).getExternalId());
  }

  /**
   * Method under test: {@link AssetProfile#AssetProfile(AssetProfile)}
   */
  @Test
  void testNewAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertEquals(assetProfile, new AssetProfile(assetProfile));
  }

  /**
   * Method under test: {@link AssetProfile#AssetProfile(AssetProfile)}
   */
  @Test
  void testNewAssetProfile2() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefault(true);

    // Act and Assert
    assertEquals(assetProfile, new AssetProfile(assetProfile));
  }
}
