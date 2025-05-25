package org.thingsboard.server.cache.resourceInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.resourceInfo.ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {ResourceInfoCacheKeyBuilder.class})
@ExtendWith(SpringExtension.class)
class ResourceInfoCacheKeyDiffblueTest {
  @Autowired
  private ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder;

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}, and {@link ResourceInfoCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceInfoCacheKey.equals(Object)", "int ResourceInfoCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult = tbResourceIdResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKeyBuilder tbResourceIdResult2 = builderResult2
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}, and {@link ResourceInfoCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceInfoCacheKey.equals(Object)", "int ResourceInfoCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder2
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult = tbResourceIdResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder3 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder4 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder4.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder3);
    ResourceInfoCacheKeyBuilder tbResourceIdResult2 = resourceInfoCacheKeyBuilder4
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}, and {@link ResourceInfoCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceInfoCacheKey.equals(Object)", "int ResourceInfoCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult = tbResourceIdResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceInfoCacheKey.equals(Object)", "int ResourceInfoCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult = tbResourceIdResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKeyBuilder tbResourceIdResult2 = builderResult
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceInfoCacheKey.equals(Object)", "int ResourceInfoCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder2
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult = tbResourceIdResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKeyBuilder tbResourceIdResult2 = builderResult
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceInfoCacheKey.equals(Object)", "int ResourceInfoCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(ResourceInfoCacheKeyBuilder.class);
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult = tbResourceIdResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    when(resourceInfoCacheKeyBuilder.build()).thenReturn(buildResult);
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder3 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder3.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder2);
    ResourceInfoCacheKeyBuilder tbResourceIdResult2 = resourceInfoCacheKeyBuilder3
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder4 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder4.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder5 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder5.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder4);
    ResourceInfoCacheKeyBuilder tbResourceIdResult3 = resourceInfoCacheKeyBuilder5
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult3 = tbResourceIdResult3
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceInfoCacheKey.equals(Object)", "int ResourceInfoCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(ResourceInfoCacheKeyBuilder.class);
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey buildResult = builderResult
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(null)
        .build();
    when(resourceInfoCacheKeyBuilder.build()).thenReturn(buildResult);
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder3 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder3.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder2);
    ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder3
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder4 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder4.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder5 = mock(ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder5.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder4);
    ResourceInfoCacheKeyBuilder tbResourceIdResult2 = resourceInfoCacheKeyBuilder5
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult3 = tbResourceIdResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceInfoCacheKey.equals(Object)", "int ResourceInfoCacheKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult = tbResourceIdResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceInfoCacheKey.equals(Object)", "int ResourceInfoCacheKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey buildResult = tbResourceIdResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ResourceInfoCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#ResourceInfoCacheKey(TenantId, TbResourceId)}
   *   <li>{@link ResourceInfoCacheKey#toString()}
   *   <li>{@link ResourceInfoCacheKey#getTbResourceId()}
   *   <li>{@link ResourceInfoCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceInfoCacheKey.<init>(TenantId, TbResourceId)",
      "TbResourceId ResourceInfoCacheKey.getTbResourceId()", "TenantId ResourceInfoCacheKey.getTenantId()",
      "String ResourceInfoCacheKey.toString()"})
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId tbResourceId = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ResourceInfoCacheKey actualResourceInfoCacheKey = new ResourceInfoCacheKey(tenantId, tbResourceId);
    String actualToStringResult = actualResourceInfoCacheKey.toString();
    TbResourceId actualTbResourceId = actualResourceInfoCacheKey.getTbResourceId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9_784f394c-42b6-435a-983c-b7beff2784f9", actualToStringResult);
    assertSame(tbResourceId, actualTbResourceId);
    assertSame(tenantId, actualResourceInfoCacheKey.getTenantId());
  }

  /**
   * Test ResourceInfoCacheKeyBuilder {@link ResourceInfoCacheKeyBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKeyBuilder#build()}
   *   <li>{@link ResourceInfoCacheKeyBuilder#tbResourceId(TbResourceId)}
   *   <li>{@link ResourceInfoCacheKeyBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test ResourceInfoCacheKeyBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceInfoCacheKeyBuilder.<init>()",
      "ResourceInfoCacheKey ResourceInfoCacheKeyBuilder.build()",
      "ResourceInfoCacheKeyBuilder ResourceInfoCacheKeyBuilder.tbResourceId(TbResourceId)",
      "ResourceInfoCacheKeyBuilder ResourceInfoCacheKeyBuilder.tenantId(TenantId)",
      "String ResourceInfoCacheKeyBuilder.toString()"})
  void testResourceInfoCacheKeyBuilderBuild() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    TbResourceId tbResourceId = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult.tbResourceId(tbResourceId);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ResourceInfoCacheKey actualBuildResult = tbResourceIdResult.tenantId(tenantId).build();

    // Assert
    assertSame(tbResourceId, actualBuildResult.getTbResourceId());
    assertSame(tenantId, actualBuildResult.getTenantId());
  }
}
