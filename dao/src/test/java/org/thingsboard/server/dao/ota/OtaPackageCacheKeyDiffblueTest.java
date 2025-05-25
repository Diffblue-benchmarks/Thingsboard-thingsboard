package org.thingsboard.server.dao.ota;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.dao.ota.OtaPackageCacheKey.OtaPackageCacheKeyBuilder;

public class OtaPackageCacheKeyDiffblueTest {
  /**
   * Test {@link OtaPackageCacheKey#equals(Object)}, and {@link OtaPackageCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageCacheKey#equals(Object)}
   *   <li>{@link OtaPackageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OtaPackageCacheKey.equals(Object)", "int OtaPackageCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtaPackageCacheKey buildResult = OtaPackageCacheKey.builder().id(null).build();
    OtaPackageCacheKey buildResult2 = OtaPackageCacheKey.builder().id(null).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link OtaPackageCacheKey#equals(Object)}, and {@link OtaPackageCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageCacheKey#equals(Object)}
   *   <li>{@link OtaPackageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OtaPackageCacheKey.equals(Object)", "int OtaPackageCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OtaPackageCacheKeyBuilder builderResult = OtaPackageCacheKey.builder();
    OtaPackageCacheKey buildResult = builderResult
        .id(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    OtaPackageCacheKeyBuilder builderResult2 = OtaPackageCacheKey.builder();
    OtaPackageCacheKey buildResult2 = builderResult2
        .id(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link OtaPackageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OtaPackageCacheKey.equals(Object)", "int OtaPackageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackageCacheKeyBuilder builderResult = OtaPackageCacheKey.builder();
    OtaPackageCacheKey buildResult = builderResult
        .id(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    OtaPackageCacheKey buildResult2 = OtaPackageCacheKey.builder().id(null).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link OtaPackageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OtaPackageCacheKey.equals(Object)", "int OtaPackageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OtaPackageCacheKeyBuilder otaPackageCacheKeyBuilder = mock(OtaPackageCacheKeyBuilder.class);
    when(otaPackageCacheKeyBuilder.id(Mockito.<OtaPackageId>any())).thenReturn(OtaPackageCacheKey.builder());
    OtaPackageCacheKey buildResult = otaPackageCacheKeyBuilder
        .id(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    OtaPackageCacheKeyBuilder builderResult = OtaPackageCacheKey.builder();
    OtaPackageCacheKey buildResult2 = builderResult
        .id(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }
}
