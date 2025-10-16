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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.TbResourceInfoFilter.TbResourceInfoFilterBuilder;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {TbResourceInfoFilterBuilder.class})
@ExtendWith(SpringExtension.class)
class TbResourceInfoFilterDiffblueTest {
  @Autowired private TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder;

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}, and {@link TbResourceInfoFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfoFilter#equals(Object)}
   *   <li>{@link TbResourceInfoFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter tbResourceInfoFilter =
        resourceSubTypesResult
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    TbResourceInfoFilterBuilder builderResult2 = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult2 =
        builderResult2.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter tbResourceInfoFilter2 =
        resourceSubTypesResult2
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(tbResourceInfoFilter, tbResourceInfoFilter2);
    assertEquals(tbResourceInfoFilter.hashCode(), tbResourceInfoFilter2.hashCode());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}, and {@link TbResourceInfoFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfoFilter#equals(Object)}
   *   <li>{@link TbResourceInfoFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter tbResourceInfoFilter =
        resourceSubTypesResult.resourceTypes(new HashSet<>()).tenantId(null).build();

    TbResourceInfoFilterBuilder builderResult2 = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult2 =
        builderResult2.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter tbResourceInfoFilter2 =
        resourceSubTypesResult2.resourceTypes(new HashSet<>()).tenantId(null).build();

    // Act and Assert
    assertEquals(tbResourceInfoFilter, tbResourceInfoFilter2);
    assertEquals(tbResourceInfoFilter.hashCode(), tbResourceInfoFilter2.hashCode());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}, and {@link TbResourceInfoFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfoFilter#equals(Object)}
   *   <li>{@link TbResourceInfoFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter tbResourceInfoFilter =
        resourceSubTypesResult
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(tbResourceInfoFilter, tbResourceInfoFilter);
    int expectedHashCodeResult = tbResourceInfoFilter.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceInfoFilter.hashCode());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    resourceSubTypes.add(ResourceSubType.IMAGE);

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        TbResourceInfoFilter.builder().resourceSubTypes(resourceSubTypes);
    TbResourceInfoFilter tbResourceInfoFilter =
        resourceSubTypesResult
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult2 =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        tbResourceInfoFilter,
        resourceSubTypesResult2
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<ResourceType> resourceTypes = new HashSet<>();
    resourceTypes.add(ResourceType.LWM2M_MODEL);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter tbResourceInfoFilter =
        builderResult
            .resourceSubTypes(new HashSet<>())
            .resourceTypes(resourceTypes)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    TbResourceInfoFilterBuilder builderResult2 = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult2.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        tbResourceInfoFilter,
        resourceSubTypesResult
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter tbResourceInfoFilter =
        resourceSubTypesResult.resourceTypes(new HashSet<>()).tenantId(null).build();

    TbResourceInfoFilterBuilder builderResult2 = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult2 =
        builderResult2.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        tbResourceInfoFilter,
        resourceSubTypesResult2
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter tbResourceInfoFilter =
        resourceSubTypesResult
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    TbResourceInfoFilterBuilder builderResult2 = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult2 =
        builderResult2.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        tbResourceInfoFilter,
        resourceSubTypesResult2.resourceTypes(new HashSet<>()).tenantId(null).build());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder =
        mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        tbResourceInfoFilterBuilder.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter tbResourceInfoFilter =
        resourceSubTypesResult
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult2 =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        tbResourceInfoFilter,
        resourceSubTypesResult2
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder =
        mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());

    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 =
        mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder);

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        tbResourceInfoFilterBuilder2.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter tbResourceInfoFilter =
        resourceSubTypesResult
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult2 =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        tbResourceInfoFilter,
        resourceSubTypesResult2
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        resourceSubTypesResult
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build(),
        null);
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoFilter.equals(Object)",
    "int TbResourceInfoFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        resourceSubTypesResult
            .resourceTypes(new HashSet<>())
            .tenantId(TenantId.SYS_TENANT_ID)
            .build(),
        "Different type to TbResourceInfoFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfoFilter#TbResourceInfoFilter(TenantId, Set, Set)}
   *   <li>{@link TbResourceInfoFilter#setResourceSubTypes(Set)}
   *   <li>{@link TbResourceInfoFilter#setResourceTypes(Set)}
   *   <li>{@link TbResourceInfoFilter#setTenantId(TenantId)}
   *   <li>{@link TbResourceInfoFilter#toString()}
   *   <li>{@link TbResourceInfoFilter#getResourceSubTypes()}
   *   <li>{@link TbResourceInfoFilter#getResourceTypes()}
   *   <li>{@link TbResourceInfoFilter#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbResourceInfoFilter.<init>(TenantId, Set, Set)",
    "Set TbResourceInfoFilter.getResourceSubTypes()",
    "Set TbResourceInfoFilter.getResourceTypes()",
    "TenantId TbResourceInfoFilter.getTenantId()",
    "void TbResourceInfoFilter.setResourceSubTypes(Set)",
    "void TbResourceInfoFilter.setResourceTypes(Set)",
    "void TbResourceInfoFilter.setTenantId(TenantId)",
    "String TbResourceInfoFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    HashSet<ResourceType> resourceTypes = new HashSet<>();

    // Act
    TbResourceInfoFilter actualTbResourceInfoFilter =
        new TbResourceInfoFilter(TenantId.SYS_TENANT_ID, resourceTypes, new HashSet<>());
    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    actualTbResourceInfoFilter.setResourceSubTypes(resourceSubTypes);
    HashSet<ResourceType> resourceTypes2 = new HashSet<>();
    actualTbResourceInfoFilter.setResourceTypes(resourceTypes2);
    actualTbResourceInfoFilter.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualTbResourceInfoFilter.toString();
    Set<ResourceSubType> actualResourceSubTypes = actualTbResourceInfoFilter.getResourceSubTypes();
    Set<ResourceType> actualResourceTypes = actualTbResourceInfoFilter.getResourceTypes();
    TenantId actualTenantId = actualTbResourceInfoFilter.getTenantId();

    // Assert
    assertEquals(
        "TbResourceInfoFilter(tenantId=13814000-1dd2-11b2-8080-808080808080, resourceTypes=[], resourceSubTypes"
            + "=[])",
        actualToStringResult);
    assertTrue(actualResourceSubTypes.isEmpty());
    assertTrue(actualResourceTypes.isEmpty());
    assertSame(resourceSubTypes, actualResourceSubTypes);
    assertSame(resourceTypes2, actualResourceTypes);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test TbResourceInfoFilterBuilder {@link TbResourceInfoFilterBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfoFilterBuilder#build()}
   *   <li>{@link TbResourceInfoFilterBuilder#resourceSubTypes(Set)}
   *   <li>{@link TbResourceInfoFilterBuilder#resourceTypes(Set)}
   *   <li>{@link TbResourceInfoFilterBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbResourceInfoFilterBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbResourceInfoFilterBuilder.<init>()",
    "TbResourceInfoFilter TbResourceInfoFilterBuilder.build()",
    "TbResourceInfoFilterBuilder TbResourceInfoFilterBuilder.resourceSubTypes(Set)",
    "TbResourceInfoFilterBuilder TbResourceInfoFilterBuilder.resourceTypes(Set)",
    "TbResourceInfoFilterBuilder TbResourceInfoFilterBuilder.tenantId(TenantId)",
    "String TbResourceInfoFilterBuilder.toString()"
  })
  void testTbResourceInfoFilterBuilderBuild() {
    // Arrange and Act
    TbResourceInfoFilterBuilder actualBuilderResult = TbResourceInfoFilter.builder();
    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    TbResourceInfoFilterBuilder actualResourceSubTypesResult =
        actualBuilderResult.resourceSubTypes(resourceSubTypes);
    HashSet<ResourceType> resourceTypes = new HashSet<>();
    TbResourceInfoFilter actualTbResourceInfoFilter =
        actualResourceSubTypesResult
            .resourceTypes(resourceTypes)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Assert
    Set<ResourceSubType> resourceSubTypes2 = actualTbResourceInfoFilter.getResourceSubTypes();
    assertTrue(resourceSubTypes2.isEmpty());
    Set<ResourceType> resourceTypes2 = actualTbResourceInfoFilter.getResourceTypes();
    assertTrue(resourceTypes2.isEmpty());
    assertSame(resourceSubTypes, resourceSubTypes2);
    assertSame(resourceTypes, resourceTypes2);
    assertSame(TenantId.SYS_TENANT_ID, actualTbResourceInfoFilter.getTenantId());
  }
}
