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
package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;

class WidgetsBundleDiffblueTest {
  /**
   * Test {@link WidgetsBundle#equals(Object)}, and {@link WidgetsBundle#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundle#equals(Object)}
   *   <li>{@link WidgetsBundle#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    WidgetsBundle widgetsBundle2 = new WidgetsBundle();

    // Act and Assert
    assertEquals(widgetsBundle, widgetsBundle2);
    assertEquals(widgetsBundle.hashCode(), widgetsBundle2.hashCode());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}, and {@link WidgetsBundle#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundle#equals(Object)}
   *   <li>{@link WidgetsBundle#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    // Act and Assert
    assertEquals(widgetsBundle, widgetsBundle);
    int expectedHashCodeResult = widgetsBundle.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundle.hashCode());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle(new WidgetsBundleId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(widgetsBundle, new WidgetsBundle());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(widgetsBundle, new WidgetsBundle());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setAlias("Alias");

    // Act and Assert
    assertNotEquals(widgetsBundle, new WidgetsBundle());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setTitle("Dr");

    // Act and Assert
    assertNotEquals(widgetsBundle, new WidgetsBundle());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetsBundle, new WidgetsBundle());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setScada(true);

    // Act and Assert
    assertNotEquals(widgetsBundle, new WidgetsBundle());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(widgetsBundle, new WidgetsBundle());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setOrder(1);

    // Act and Assert
    assertNotEquals(widgetsBundle, new WidgetsBundle());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setExternalId(new WidgetsBundleId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(widgetsBundle, new WidgetsBundle());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundle, new WidgetsBundle());
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(widgetsBundle, widgetsBundle2);
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setAlias("Alias");

    // Act and Assert
    assertNotEquals(widgetsBundle, widgetsBundle2);
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(widgetsBundle, widgetsBundle2);
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetsBundle, widgetsBundle2);
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(widgetsBundle, widgetsBundle2);
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setOrder(1);

    // Act and Assert
    assertNotEquals(widgetsBundle, widgetsBundle2);
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setExternalId(new WidgetsBundleId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(widgetsBundle, widgetsBundle2);
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundle, widgetsBundle2);
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundle(), null);
  }

  /**
   * Test {@link WidgetsBundle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetsBundle.equals(Object)", "int WidgetsBundle.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundle(), "Different type to WidgetsBundle");
  }

  /**
   * Test {@link WidgetsBundle#getExternalId()}.
   *
   * <p>Method under test: {@link WidgetsBundle#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundleId WidgetsBundle.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new WidgetsBundle().getExternalId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundle#WidgetsBundle()}
   *   <li>{@link WidgetsBundle#setAlias(String)}
   *   <li>{@link WidgetsBundle#setDescription(String)}
   *   <li>{@link WidgetsBundle#setExternalId(WidgetsBundleId)}
   *   <li>{@link WidgetsBundle#setImage(String)}
   *   <li>{@link WidgetsBundle#setOrder(Integer)}
   *   <li>{@link WidgetsBundle#setScada(boolean)}
   *   <li>{@link WidgetsBundle#setTenantId(TenantId)}
   *   <li>{@link WidgetsBundle#setTitle(String)}
   *   <li>{@link WidgetsBundle#setVersion(Long)}
   *   <li>{@link WidgetsBundle#toString()}
   *   <li>{@link WidgetsBundle#getAlias()}
   *   <li>{@link WidgetsBundle#getDescription()}
   *   <li>{@link WidgetsBundle#getImage()}
   *   <li>{@link WidgetsBundle#getName()}
   *   <li>{@link WidgetsBundle#getOrder()}
   *   <li>{@link WidgetsBundle#getTenantId()}
   *   <li>{@link WidgetsBundle#getTitle()}
   *   <li>{@link WidgetsBundle#getVersion()}
   *   <li>{@link WidgetsBundle#isScada()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundle.<init>()",
    "void WidgetsBundle.<init>(WidgetsBundleId)",
    "String WidgetsBundle.getAlias()",
    "String WidgetsBundle.getDescription()",
    "String WidgetsBundle.getImage()",
    "String WidgetsBundle.getName()",
    "Integer WidgetsBundle.getOrder()",
    "TenantId WidgetsBundle.getTenantId()",
    "String WidgetsBundle.getTitle()",
    "Long WidgetsBundle.getVersion()",
    "boolean WidgetsBundle.isScada()",
    "void WidgetsBundle.setAlias(String)",
    "void WidgetsBundle.setDescription(String)",
    "void WidgetsBundle.setExternalId(WidgetsBundleId)",
    "void WidgetsBundle.setImage(String)",
    "void WidgetsBundle.setOrder(Integer)",
    "void WidgetsBundle.setScada(boolean)",
    "void WidgetsBundle.setTenantId(TenantId)",
    "void WidgetsBundle.setTitle(String)",
    "void WidgetsBundle.setVersion(Long)",
    "String WidgetsBundle.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    WidgetsBundle actualWidgetsBundle = new WidgetsBundle();
    actualWidgetsBundle.setAlias("Alias");
    actualWidgetsBundle.setDescription("The characteristics of someone or something");
    WidgetsBundleId externalId = new WidgetsBundleId(EntityId.NULL_UUID);
    actualWidgetsBundle.setExternalId(externalId);
    actualWidgetsBundle.setImage("Image");
    actualWidgetsBundle.setOrder(1);
    actualWidgetsBundle.setScada(true);
    actualWidgetsBundle.setTenantId(TenantId.SYS_TENANT_ID);
    actualWidgetsBundle.setTitle("Dr");
    actualWidgetsBundle.setVersion(1L);
    String actualToStringResult = actualWidgetsBundle.toString();
    String actualAlias = actualWidgetsBundle.getAlias();
    String actualDescription = actualWidgetsBundle.getDescription();
    String actualImage = actualWidgetsBundle.getImage();
    String actualName = actualWidgetsBundle.getName();
    Integer actualOrder = actualWidgetsBundle.getOrder();
    TenantId actualTenantId = actualWidgetsBundle.getTenantId();
    String actualTitle = actualWidgetsBundle.getTitle();
    Long actualVersion = actualWidgetsBundle.getVersion();
    boolean actualIsScadaResult = actualWidgetsBundle.isScada();

    // Assert
    assertEquals("Alias", actualAlias);
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(
        "WidgetsBundle{tenantId=13814000-1dd2-11b2-8080-808080808080, alias='Alias', title='Dr', description='The"
            + " characteristics of someone or something'}",
        actualToStringResult);
    assertNull(actualWidgetsBundle.getId());
    assertEquals(0L, actualWidgetsBundle.getCreatedTime());
    assertEquals(1, actualOrder.intValue());
    assertEquals(1L, actualVersion.longValue());
    assertTrue(actualIsScadaResult);
    assertSame(externalId, actualWidgetsBundle.getExternalId());
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@link WidgetsBundleId#WidgetsBundleId(UUID)} with id is {@link
   *       EntityId#NULL_UUID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundle#WidgetsBundle(WidgetsBundleId)}
   *   <li>{@link WidgetsBundle#setAlias(String)}
   *   <li>{@link WidgetsBundle#setDescription(String)}
   *   <li>{@link WidgetsBundle#setExternalId(WidgetsBundleId)}
   *   <li>{@link WidgetsBundle#setImage(String)}
   *   <li>{@link WidgetsBundle#setOrder(Integer)}
   *   <li>{@link WidgetsBundle#setScada(boolean)}
   *   <li>{@link WidgetsBundle#setTenantId(TenantId)}
   *   <li>{@link WidgetsBundle#setTitle(String)}
   *   <li>{@link WidgetsBundle#setVersion(Long)}
   *   <li>{@link WidgetsBundle#toString()}
   *   <li>{@link WidgetsBundle#getAlias()}
   *   <li>{@link WidgetsBundle#getDescription()}
   *   <li>{@link WidgetsBundle#getImage()}
   *   <li>{@link WidgetsBundle#getName()}
   *   <li>{@link WidgetsBundle#getOrder()}
   *   <li>{@link WidgetsBundle#getTenantId()}
   *   <li>{@link WidgetsBundle#getTitle()}
   *   <li>{@link WidgetsBundle#getVersion()}
   *   <li>{@link WidgetsBundle#isScada()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return Id is WidgetsBundleId(UUID) with id is NULL_UUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundle.<init>()",
    "void WidgetsBundle.<init>(WidgetsBundleId)",
    "String WidgetsBundle.getAlias()",
    "String WidgetsBundle.getDescription()",
    "String WidgetsBundle.getImage()",
    "String WidgetsBundle.getName()",
    "Integer WidgetsBundle.getOrder()",
    "TenantId WidgetsBundle.getTenantId()",
    "String WidgetsBundle.getTitle()",
    "Long WidgetsBundle.getVersion()",
    "boolean WidgetsBundle.isScada()",
    "void WidgetsBundle.setAlias(String)",
    "void WidgetsBundle.setDescription(String)",
    "void WidgetsBundle.setExternalId(WidgetsBundleId)",
    "void WidgetsBundle.setImage(String)",
    "void WidgetsBundle.setOrder(Integer)",
    "void WidgetsBundle.setScada(boolean)",
    "void WidgetsBundle.setTenantId(TenantId)",
    "void WidgetsBundle.setTitle(String)",
    "void WidgetsBundle.setVersion(Long)",
    "String WidgetsBundle.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsWidgetsBundleIdWithIdIsNull_uuid() {
    // Arrange
    WidgetsBundleId id = new WidgetsBundleId(EntityId.NULL_UUID);

    // Act
    WidgetsBundle actualWidgetsBundle = new WidgetsBundle(id);
    actualWidgetsBundle.setAlias("Alias");
    actualWidgetsBundle.setDescription("The characteristics of someone or something");
    WidgetsBundleId externalId = new WidgetsBundleId(EntityId.NULL_UUID);
    actualWidgetsBundle.setExternalId(externalId);
    actualWidgetsBundle.setImage("Image");
    actualWidgetsBundle.setOrder(1);
    actualWidgetsBundle.setScada(true);
    actualWidgetsBundle.setTenantId(TenantId.SYS_TENANT_ID);
    actualWidgetsBundle.setTitle("Dr");
    actualWidgetsBundle.setVersion(1L);
    String actualToStringResult = actualWidgetsBundle.toString();
    String actualAlias = actualWidgetsBundle.getAlias();
    String actualDescription = actualWidgetsBundle.getDescription();
    String actualImage = actualWidgetsBundle.getImage();
    String actualName = actualWidgetsBundle.getName();
    Integer actualOrder = actualWidgetsBundle.getOrder();
    TenantId actualTenantId = actualWidgetsBundle.getTenantId();
    String actualTitle = actualWidgetsBundle.getTitle();
    Long actualVersion = actualWidgetsBundle.getVersion();
    boolean actualIsScadaResult = actualWidgetsBundle.isScada();

    // Assert
    assertEquals("Alias", actualAlias);
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(
        "WidgetsBundle{tenantId=13814000-1dd2-11b2-8080-808080808080, alias='Alias', title='Dr', description='The"
            + " characteristics of someone or something'}",
        actualToStringResult);
    assertEquals(0L, actualWidgetsBundle.getCreatedTime());
    assertEquals(1, actualOrder.intValue());
    assertEquals(1L, actualVersion.longValue());
    assertTrue(actualIsScadaResult);
    assertSame(externalId, actualWidgetsBundle.getExternalId());
    assertSame(id, actualWidgetsBundle.getId());
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link WidgetsBundle#WidgetsBundle(WidgetsBundle)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link WidgetsBundle#WidgetsBundle()} Scada is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#WidgetsBundle(WidgetsBundle)}
   */
  @Test
  @DisplayName(
      "Test new WidgetsBundle(WidgetsBundle); given 'true'; when WidgetsBundle() Scada is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundle.<init>(WidgetsBundle)"})
  void testNewWidgetsBundle_givenTrue_whenWidgetsBundleScadaIsTrue() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setScada(true);

    // Act
    WidgetsBundle actualWidgetsBundle = new WidgetsBundle(widgetsBundle);

    // Assert
    assertEquals(widgetsBundle, actualWidgetsBundle);
  }

  /**
   * Test {@link WidgetsBundle#WidgetsBundle(WidgetsBundle)}.
   *
   * <ul>
   *   <li>When {@link WidgetsBundle#WidgetsBundle()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundle#WidgetsBundle(WidgetsBundle)}
   */
  @Test
  @DisplayName("Test new WidgetsBundle(WidgetsBundle); when WidgetsBundle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundle.<init>(WidgetsBundle)"})
  void testNewWidgetsBundle_whenWidgetsBundle() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    // Act
    WidgetsBundle actualWidgetsBundle = new WidgetsBundle(widgetsBundle);

    // Assert
    assertEquals(widgetsBundle, actualWidgetsBundle);
  }

  /**
   * Test {@link WidgetsBundle#getId()}.
   *
   * <p>Method under test: {@link WidgetsBundle#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundleId WidgetsBundle.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new WidgetsBundle().getId());
  }

  /**
   * Test {@link WidgetsBundle#getCreatedTime()}.
   *
   * <p>Method under test: {@link WidgetsBundle#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long WidgetsBundle.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new WidgetsBundle().getCreatedTime());
  }
}
