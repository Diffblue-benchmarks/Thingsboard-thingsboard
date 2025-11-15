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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class SingleEntityVersionLoadRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityVersionLoadRequest#equals(Object)}
   *   <li>{@link SingleEntityVersionLoadRequest#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityVersionLoadRequest#equals(Object)}
   *   <li>{@link SingleEntityVersionLoadRequest#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
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
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeVersionLoadConfig config = mock(EntityTypeVersionLoadConfig.class);
    doNothing().when(config).setLoadAttributes(anyBoolean());
    doNothing().when(config).setLoadCredentials(anyBoolean());
    doNothing().when(config).setLoadRelations(anyBoolean());
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
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeVersionLoadConfig config = mock(EntityTypeVersionLoadConfig.class);
    doNothing().when(config).setLoadAttributes(anyBoolean());
    doNothing().when(config).setLoadCredentials(anyBoolean());
    doNothing().when(config).setLoadRelations(anyBoolean());
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
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityTypeVersionLoadConfig config = mock(EntityTypeVersionLoadConfig.class);
    doNothing().when(config).setLoadAttributes(anyBoolean());
    doNothing().when(config).setLoadCredentials(anyBoolean());
    doNothing().when(config).setLoadRelations(anyBoolean());
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
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityTypeVersionLoadConfig config = mock(EntityTypeVersionLoadConfig.class);
    doNothing().when(config).setLoadAttributes(anyBoolean());
    doNothing().when(config).setLoadCredentials(anyBoolean());
    doNothing().when(config).setLoadRelations(anyBoolean());
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
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityTypeVersionLoadConfig config = mock(EntityTypeVersionLoadConfig.class);
    doNothing().when(config).setLoadAttributes(anyBoolean());
    doNothing().when(config).setLoadCredentials(anyBoolean());
    doNothing().when(config).setLoadRelations(anyBoolean());
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
    assertNotEquals(singleEntityVersionLoadRequest, singleEntityVersionLoadRequest2);
  }

  /**
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
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
   * Method under test: {@link SingleEntityVersionLoadRequest#equals(Object)}
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SingleEntityVersionLoadRequest}
   *   <li>{@link SingleEntityVersionLoadRequest#setConfig(VersionLoadConfig)}
   *   <li>{@link SingleEntityVersionLoadRequest#setExternalEntityId(EntityId)}
   *   <li>{@link SingleEntityVersionLoadRequest#toString()}
   *   <li>{@link SingleEntityVersionLoadRequest#getConfig()}
   *   <li>{@link SingleEntityVersionLoadRequest#getExternalEntityId()}
   *   <li>{@link SingleEntityVersionLoadRequest#getType()}
   * </ul>
   */
  @Test
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

    // Assert that nothing has changed
    assertEquals(
        "SingleEntityVersionLoadRequest(externalEntityId=13814000-1dd2-11b2-8080-808080808080, config"
            + "=VersionLoadConfig(loadRelations=true, loadAttributes=true, loadCredentials=true))",
        actualToStringResult);
    assertEquals(VersionLoadRequestType.SINGLE_ENTITY, actualSingleEntityVersionLoadRequest.getType());
    assertSame(config, actualConfig);
    assertSame(((TenantId) actualExternalEntityId).SYS_TENANT_ID, actualExternalEntityId);
  }
}
