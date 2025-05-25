package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
  @Autowired
  private TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder;

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}, and {@link TbResourceInfoFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoFilter#equals(Object)}
   *   <li>{@link TbResourceInfoFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilterBuilder builderResult2 = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult2 = builderResult2.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}, and {@link TbResourceInfoFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoFilter#equals(Object)}
   *   <li>{@link TbResourceInfoFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult2 = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder2.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult2 = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder3 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder3.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder2);
    TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder3.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult2 = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder3 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder3.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder2);
    TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder3.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult2 = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>()).tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(TbResourceInfoFilterBuilder.class);
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    when(tbResourceInfoFilterBuilder.build()).thenReturn(buildResult);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder3 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder3.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder2);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder4 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder4.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder3);
    TbResourceInfoFilterBuilder resourceSubTypesResult2 = tbResourceInfoFilterBuilder4
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilterBuilder builderResult2 = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult3 = builderResult2.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult3 = resourceSubTypesResult3.resourceTypes(new HashSet<>()).tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    resourceSubTypes.add(ResourceSubType.IMAGE);
    TbResourceInfoFilterBuilder resourceSubTypesResult = TbResourceInfoFilter.builder()
        .resourceSubTypes(resourceSubTypes);
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>()).tenantId(null).build();
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.build()).thenReturn(buildResult);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder3 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder3.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder2);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder4 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder4.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder3);
    TbResourceInfoFilterBuilder resourceSubTypesResult2 = tbResourceInfoFilterBuilder4
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult3 = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult3 = resourceSubTypesResult3.resourceTypes(new HashSet<>()).tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    resourceSubTypes.add(ResourceSubType.IMAGE);
    TbResourceInfoFilterBuilder resourceSubTypesResult = TbResourceInfoFilter.builder()
        .resourceSubTypes(resourceSubTypes);

    HashSet<ResourceType> resourceTypes = new HashSet<>();
    resourceTypes.add(ResourceType.JKS);
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(resourceTypes).tenantId(null).build();
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.build()).thenReturn(buildResult);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder3 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder3.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder2);
    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder4 = mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder4.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder3);
    TbResourceInfoFilterBuilder resourceSubTypesResult2 = tbResourceInfoFilterBuilder4
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult3 = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult3 = resourceSubTypesResult3.resourceTypes(new HashSet<>()).tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link TbResourceInfoFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfoFilter.equals(Object)", "int TbResourceInfoFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TbResourceInfoFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfoFilter.<init>(TenantId, Set, Set)",
      "Set TbResourceInfoFilter.getResourceSubTypes()", "Set TbResourceInfoFilter.getResourceTypes()",
      "TenantId TbResourceInfoFilter.getTenantId()", "void TbResourceInfoFilter.setResourceSubTypes(Set)",
      "void TbResourceInfoFilter.setResourceTypes(Set)", "void TbResourceInfoFilter.setTenantId(TenantId)",
      "String TbResourceInfoFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange
    HashSet<ResourceType> resourceTypes = new HashSet<>();

    // Act
    TbResourceInfoFilter actualTbResourceInfoFilter = new TbResourceInfoFilter(TenantId.SYS_TENANT_ID, resourceTypes,
        new HashSet<>());
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
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test TbResourceInfoFilterBuilder {@link TbResourceInfoFilterBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoFilterBuilder#build()}
   *   <li>{@link TbResourceInfoFilterBuilder#resourceSubTypes(Set)}
   *   <li>{@link TbResourceInfoFilterBuilder#resourceTypes(Set)}
   *   <li>{@link TbResourceInfoFilterBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbResourceInfoFilterBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfoFilterBuilder.<init>()",
      "TbResourceInfoFilter TbResourceInfoFilterBuilder.build()",
      "TbResourceInfoFilterBuilder TbResourceInfoFilterBuilder.resourceSubTypes(Set)",
      "TbResourceInfoFilterBuilder TbResourceInfoFilterBuilder.resourceTypes(Set)",
      "TbResourceInfoFilterBuilder TbResourceInfoFilterBuilder.tenantId(TenantId)",
      "String TbResourceInfoFilterBuilder.toString()"})
  void testTbResourceInfoFilterBuilderBuild() {
    // Arrange
    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult.resourceSubTypes(resourceSubTypes);
    HashSet<ResourceType> resourceTypes = new HashSet<>();

    // Act
    TbResourceInfoFilter actualBuildResult = resourceSubTypesResult.resourceTypes(resourceTypes)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    Set<ResourceSubType> resourceSubTypes2 = actualBuildResult.getResourceSubTypes();
    assertTrue(resourceSubTypes2.isEmpty());
    Set<ResourceType> resourceTypes2 = actualBuildResult.getResourceTypes();
    assertTrue(resourceTypes2.isEmpty());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(resourceSubTypes, resourceSubTypes2);
    assertSame(resourceTypes, resourceTypes2);
  }
}
