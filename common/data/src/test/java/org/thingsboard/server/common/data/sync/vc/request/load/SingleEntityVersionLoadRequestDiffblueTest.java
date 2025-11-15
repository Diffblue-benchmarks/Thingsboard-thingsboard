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
package org.thingsboard.server.common.data.sync.vc.request.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class SingleEntityVersionLoadRequestDiffblueTest {
  /**
   * Test {@link SingleEntityVersionLoadRequest#equals(Object)}, and {@link SingleEntityVersionLoadRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityVersionLoadRequest#equals(Object)}
   *   <li>{@link SingleEntityVersionLoadRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityVersionLoadRequest.equals(Object)",
      "int SingleEntityVersionLoadRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest.setVersionId("42");

    VersionLoadConfig config2 = new VersionLoadConfig();
    config2.setLoadAttributes(true);
    config2.setLoadCredentials(true);
    config2.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest2 = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest2.setConfig(config2);
    singleEntityVersionLoadRequest2.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertEquals(singleEntityVersionLoadRequest, singleEntityVersionLoadRequest2);
    int expectedHashCodeResult = singleEntityVersionLoadRequest.hashCode();
    assertEquals(expectedHashCodeResult, singleEntityVersionLoadRequest2.hashCode());
  }

  /**
   * Test {@link SingleEntityVersionLoadRequest#equals(Object)}, and {@link SingleEntityVersionLoadRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityVersionLoadRequest#equals(Object)}
   *   <li>{@link SingleEntityVersionLoadRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityVersionLoadRequest.equals(Object)",
      "int SingleEntityVersionLoadRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(null);
    singleEntityVersionLoadRequest.setVersionId("42");

    VersionLoadConfig config2 = new VersionLoadConfig();
    config2.setLoadAttributes(true);
    config2.setLoadCredentials(true);
    config2.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest2 = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest2.setConfig(config2);
    singleEntityVersionLoadRequest2.setExternalEntityId(null);
    singleEntityVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertEquals(singleEntityVersionLoadRequest, singleEntityVersionLoadRequest2);
    int expectedHashCodeResult = singleEntityVersionLoadRequest.hashCode();
    assertEquals(expectedHashCodeResult, singleEntityVersionLoadRequest2.hashCode());
  }

  /**
   * Test {@link SingleEntityVersionLoadRequest#equals(Object)}, and {@link SingleEntityVersionLoadRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityVersionLoadRequest#equals(Object)}
   *   <li>{@link SingleEntityVersionLoadRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityVersionLoadRequest.equals(Object)",
      "int SingleEntityVersionLoadRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertEquals(singleEntityVersionLoadRequest, singleEntityVersionLoadRequest);
    int expectedHashCodeResult = singleEntityVersionLoadRequest.hashCode();
    assertEquals(expectedHashCodeResult, singleEntityVersionLoadRequest.hashCode());
  }

  /**
   * Test {@link SingleEntityVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityVersionLoadRequest.equals(Object)",
      "int SingleEntityVersionLoadRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig config = new EntityTypeVersionLoadConfig();
    config.setFindExistingEntityByName(true);
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);
    config.setRemoveOtherEntities(true);
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest.setVersionId("42");

    VersionLoadConfig config2 = new VersionLoadConfig();
    config2.setLoadAttributes(true);
    config2.setLoadCredentials(true);
    config2.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest2 = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest2.setConfig(config2);
    singleEntityVersionLoadRequest2.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(singleEntityVersionLoadRequest, singleEntityVersionLoadRequest2);
  }

  /**
   * Test {@link SingleEntityVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityVersionLoadRequest.equals(Object)",
      "int SingleEntityVersionLoadRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(null);
    singleEntityVersionLoadRequest.setVersionId("42");

    VersionLoadConfig config2 = new VersionLoadConfig();
    config2.setLoadAttributes(true);
    config2.setLoadCredentials(true);
    config2.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest2 = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest2.setConfig(config2);
    singleEntityVersionLoadRequest2.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(singleEntityVersionLoadRequest, singleEntityVersionLoadRequest2);
  }

  /**
   * Test {@link SingleEntityVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityVersionLoadRequest.equals(Object)",
      "int SingleEntityVersionLoadRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(new AlarmId(EntityId.NULL_UUID));
    singleEntityVersionLoadRequest.setVersionId("42");

    VersionLoadConfig config2 = new VersionLoadConfig();
    config2.setLoadAttributes(true);
    config2.setLoadCredentials(true);
    config2.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest2 = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest2.setConfig(config2);
    singleEntityVersionLoadRequest2.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(singleEntityVersionLoadRequest, singleEntityVersionLoadRequest2);
  }

  /**
   * Test {@link SingleEntityVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityVersionLoadRequest.equals(Object)",
      "int SingleEntityVersionLoadRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest.setVersionId("1.0.2");

    VersionLoadConfig config2 = new VersionLoadConfig();
    config2.setLoadAttributes(true);
    config2.setLoadCredentials(true);
    config2.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest2 = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest2.setConfig(config2);
    singleEntityVersionLoadRequest2.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(singleEntityVersionLoadRequest, singleEntityVersionLoadRequest2);
  }

  /**
   * Test {@link SingleEntityVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityVersionLoadRequest.equals(Object)",
      "int SingleEntityVersionLoadRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertNotEquals(singleEntityVersionLoadRequest, null);
  }

  /**
   * Test {@link SingleEntityVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityVersionLoadRequest.equals(Object)",
      "int SingleEntityVersionLoadRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertNotEquals(singleEntityVersionLoadRequest, "Different type to SingleEntityVersionLoadRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SingleEntityVersionLoadRequest}
   *   <li>{@link SingleEntityVersionLoadRequest#setConfig(VersionLoadConfig)}
   *   <li>{@link SingleEntityVersionLoadRequest#setExternalEntityId(EntityId)}
   *   <li>{@link SingleEntityVersionLoadRequest#toString()}
   *   <li>{@link SingleEntityVersionLoadRequest#getConfig()}
   *   <li>{@link SingleEntityVersionLoadRequest#getExternalEntityId()}
   *   <li>{@link SingleEntityVersionLoadRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SingleEntityVersionLoadRequest.<init>()",
      "VersionLoadConfig SingleEntityVersionLoadRequest.getConfig()",
      "EntityId SingleEntityVersionLoadRequest.getExternalEntityId()",
      "VersionLoadRequestType SingleEntityVersionLoadRequest.getType()",
      "void SingleEntityVersionLoadRequest.setConfig(VersionLoadConfig)",
      "void SingleEntityVersionLoadRequest.setExternalEntityId(EntityId)",
      "String SingleEntityVersionLoadRequest.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SingleEntityVersionLoadRequest actualSingleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);
    actualSingleEntityVersionLoadRequest.setConfig(config);
    actualSingleEntityVersionLoadRequest.setExternalEntityId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualSingleEntityVersionLoadRequest.toString();
    VersionLoadConfig actualConfig = actualSingleEntityVersionLoadRequest.getConfig();
    EntityId actualExternalEntityId = actualSingleEntityVersionLoadRequest.getExternalEntityId();
    VersionLoadRequestType actualType = actualSingleEntityVersionLoadRequest.getType();

    // Assert
    assertEquals(
        "SingleEntityVersionLoadRequest(externalEntityId=13814000-1dd2-11b2-8080-808080808080, config"
            + "=VersionLoadConfig(loadRelations=true, loadAttributes=true, loadCredentials=true))",
        actualToStringResult);
    assertNull(actualSingleEntityVersionLoadRequest.getVersionId());
    assertEquals(VersionLoadRequestType.SINGLE_ENTITY, actualType);
    assertSame(config, actualConfig);
    assertSame(((TenantId) actualExternalEntityId).SYS_TENANT_ID, actualExternalEntityId);
  }
}
