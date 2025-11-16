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
package org.thingsboard.server.common.data.sync.vc.request.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class VersionCreateRequestDiffblueTest {
  /**
   * Test {@link VersionCreateRequest#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link ComplexVersionCreateRequest} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when ComplexVersionCreateRequest (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionCreateRequest.canEqual(Object)"})
  void testCanEqual_whenComplexVersionCreateRequest_thenReturnTrue() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    // Act and Assert
    assertTrue(complexVersionCreateRequest.canEqual(new ComplexVersionCreateRequest()));
  }

  /**
   * Test {@link VersionCreateRequest#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionCreateRequest.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ComplexVersionCreateRequest().canEqual("Other"));
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}, and {@link VersionCreateRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionCreateRequest.equals(Object)",
    "int VersionCreateRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    ComplexVersionCreateRequest complexVersionCreateRequest2 = new ComplexVersionCreateRequest();

    // Act and Assert
    assertEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
    assertEquals(complexVersionCreateRequest.hashCode(), complexVersionCreateRequest2.hashCode());
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}, and {@link VersionCreateRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionCreateRequest.equals(Object)",
    "int VersionCreateRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    // Act and Assert
    assertEquals(complexVersionCreateRequest, complexVersionCreateRequest);
    int expectedHashCodeResult = complexVersionCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, complexVersionCreateRequest.hashCode());
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionCreateRequest.equals(Object)",
    "int VersionCreateRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    VersionCreateConfig config = new VersionCreateConfig();
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest =
        new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, singleEntityVersionCreateRequest);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionCreateRequest.equals(Object)",
    "int VersionCreateRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    ComplexVersionCreateRequest complexVersionCreateRequest2 =
        mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn("1.0.2");
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionCreateRequest.equals(Object)",
    "int VersionCreateRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setVersionName("1.0.2");

    ComplexVersionCreateRequest complexVersionCreateRequest2 =
        mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn("1.0.2");
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionCreateRequest.equals(Object)",
    "int VersionCreateRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setVersionName("Version Name");

    ComplexVersionCreateRequest complexVersionCreateRequest2 =
        mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn("1.0.2");
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionCreateRequest.equals(Object)",
    "int VersionCreateRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setVersionName("1.0.2");

    ComplexVersionCreateRequest complexVersionCreateRequest2 =
        mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn("1.0.2");
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionCreateRequest.equals(Object)",
    "int VersionCreateRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("1.0.2");
    complexVersionCreateRequest.setVersionName("1.0.2");

    ComplexVersionCreateRequest complexVersionCreateRequest2 =
        mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn("1.0.2");
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionCreateRequest.equals(Object)",
    "int VersionCreateRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComplexVersionCreateRequest(), null);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionCreateRequest.equals(Object)",
    "int VersionCreateRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComplexVersionCreateRequest(), "Different type to VersionCreateRequest");
  }

  /**
   * Test {@link VersionCreateRequest#getBranch()}.
   *
   * <p>Method under test: {@link VersionCreateRequest#getBranch()}
   */
  @Test
  @DisplayName("Test getBranch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String VersionCreateRequest.getBranch()"})
  void testGetBranch() {
    // Arrange, Act and Assert
    assertNull(new ComplexVersionCreateRequest().getBranch());
  }

  /**
   * Test {@link VersionCreateRequest#getVersionName()}.
   *
   * <p>Method under test: {@link VersionCreateRequest#getVersionName()}
   */
  @Test
  @DisplayName("Test getVersionName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String VersionCreateRequest.getVersionName()"})
  void testGetVersionName() {
    // Arrange, Act and Assert
    assertNull(new ComplexVersionCreateRequest().getVersionName());
  }

  /**
   * Test {@link VersionCreateRequest#setBranch(String)}.
   *
   * <p>Method under test: {@link VersionCreateRequest#setBranch(String)}
   */
  @Test
  @DisplayName("Test setBranch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VersionCreateRequest.setBranch(String)"})
  void testSetBranch() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    // Act
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");

    // Assert
    assertEquals("janedoe/featurebranch", complexVersionCreateRequest.getBranch());
  }

  /**
   * Test {@link VersionCreateRequest#setVersionName(String)}.
   *
   * <p>Method under test: {@link VersionCreateRequest#setVersionName(String)}
   */
  @Test
  @DisplayName("Test setVersionName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VersionCreateRequest.setVersionName(String)"})
  void testSetVersionName() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    // Act
    complexVersionCreateRequest.setVersionName("1.0.2");

    // Assert
    assertEquals("1.0.2", complexVersionCreateRequest.getVersionName());
  }

  /**
   * Test {@link VersionCreateRequest#toString()}.
   *
   * <p>Method under test: {@link VersionCreateRequest#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String VersionCreateRequest.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ComplexVersionCreateRequest(syncStrategy=null, entityTypes=null)",
        new ComplexVersionCreateRequest().toString());
  }
}
