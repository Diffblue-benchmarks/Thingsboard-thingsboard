package org.thingsboard.server.dao.tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.TenantProfileId;

public class TenantProfileCacheKeyDiffblueTest {
  /**
   * Test {@link TenantProfileCacheKey#fromId(TenantProfileId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return TenantProfileId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileCacheKey#fromId(TenantProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfileCacheKey TenantProfileCacheKey.fromId(TenantProfileId)"})
  public void testFromId_whenNull_thenReturnTenantProfileIdIsNull() {
    // Arrange and Act
    TenantProfileCacheKey actualFromIdResult = TenantProfileCacheKey.fromId(null);

    // Assert
    assertNull(actualFromIdResult.getTenantProfileId());
    assertFalse(actualFromIdResult.isDefaultProfile());
  }

  /**
   * Test {@link TenantProfileCacheKey#defaultProfile()}.
   * <p>
   * Method under test: {@link TenantProfileCacheKey#defaultProfile()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfileCacheKey TenantProfileCacheKey.defaultProfile()"})
  public void testDefaultProfile() {
    // Arrange and Act
    TenantProfileCacheKey actualDefaultProfileResult = TenantProfileCacheKey.defaultProfile();

    // Assert
    assertNull(actualDefaultProfileResult.getTenantProfileId());
    assertTrue(actualDefaultProfileResult.isDefaultProfile());
  }

  /**
   * Test {@link TenantProfileCacheKey#toString()}.
   * <ul>
   *   <li>Given defaultProfile.</li>
   *   <li>Then return {@code default}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileCacheKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TenantProfileCacheKey.toString()"})
  public void testToString_givenDefaultProfile_thenReturnDefault() {
    // Arrange, Act and Assert
    assertEquals("default", TenantProfileCacheKey.defaultProfile().toString());
  }

  /**
   * Test {@link TenantProfileCacheKey#toString()}.
   * <ul>
   *   <li>Then return {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileCacheKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TenantProfileCacheKey.toString()"})
  public void testToString_thenReturn784f394c42b6435a983cB7beff2784f9() {
    // Arrange, Act and Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9",
        TenantProfileCacheKey.fromId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .toString());
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}, and {@link TenantProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileCacheKey#equals(Object)}
   *   <li>{@link TenantProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileCacheKey.equals(Object)", "int TenantProfileCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfileCacheKey defaultProfileResult = TenantProfileCacheKey.defaultProfile();
    TenantProfileCacheKey defaultProfileResult2 = TenantProfileCacheKey.defaultProfile();

    // Act and Assert
    assertEquals(defaultProfileResult, defaultProfileResult2);
    int expectedHashCodeResult = defaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, defaultProfileResult2.hashCode());
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}, and {@link TenantProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileCacheKey#equals(Object)}
   *   <li>{@link TenantProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileCacheKey.equals(Object)", "int TenantProfileCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfileCacheKey fromIdResult = TenantProfileCacheKey
        .fromId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TenantProfileCacheKey fromIdResult2 = TenantProfileCacheKey
        .fromId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(fromIdResult, fromIdResult2);
    int expectedHashCodeResult = fromIdResult.hashCode();
    assertEquals(expectedHashCodeResult, fromIdResult2.hashCode());
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}, and {@link TenantProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileCacheKey#equals(Object)}
   *   <li>{@link TenantProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileCacheKey.equals(Object)", "int TenantProfileCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfileCacheKey defaultProfileResult = TenantProfileCacheKey.defaultProfile();

    // Act and Assert
    assertEquals(defaultProfileResult, defaultProfileResult);
    int expectedHashCodeResult = defaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, defaultProfileResult.hashCode());
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileCacheKey.equals(Object)", "int TenantProfileCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantProfileCacheKey.defaultProfile(), 1);
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileCacheKey.equals(Object)", "int TenantProfileCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfileCacheKey fromIdResult = TenantProfileCacheKey.fromId(null);

    // Act and Assert
    assertNotEquals(fromIdResult, TenantProfileCacheKey.defaultProfile());
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileCacheKey.equals(Object)", "int TenantProfileCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantProfileCacheKey fromIdResult = TenantProfileCacheKey.fromId(null);

    // Act and Assert
    assertNotEquals(fromIdResult,
        TenantProfileCacheKey.fromId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileCacheKey.equals(Object)", "int TenantProfileCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantProfileCacheKey fromIdResult = TenantProfileCacheKey.fromId(mock(TenantProfileId.class));

    // Act and Assert
    assertNotEquals(fromIdResult,
        TenantProfileCacheKey.fromId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileCacheKey.equals(Object)", "int TenantProfileCacheKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantProfileCacheKey.defaultProfile(), null);
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileCacheKey.equals(Object)", "int TenantProfileCacheKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantProfileCacheKey.defaultProfile(), "Different type to TenantProfileCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileCacheKey#getTenantProfileId()}
   *   <li>{@link TenantProfileCacheKey#isDefaultProfile()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfileId TenantProfileCacheKey.getTenantProfileId()",
      "boolean TenantProfileCacheKey.isDefaultProfile()"})
  public void testGettersAndSetters() {
    // Arrange
    TenantProfileCacheKey defaultProfileResult = TenantProfileCacheKey.defaultProfile();

    // Act
    TenantProfileId actualTenantProfileId = defaultProfileResult.getTenantProfileId();

    // Assert
    assertNull(actualTenantProfileId);
    assertTrue(defaultProfileResult.isDefaultProfile());
  }
}
