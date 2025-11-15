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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class SingleEntityVersionCreateRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityVersionCreateRequest#equals(Object)}
   *   <li>{@link SingleEntityVersionCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionCreateConfig config = new VersionCreateConfig();
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    VersionCreateConfig config2 = new VersionCreateConfig();
    config2.setSaveAttributes(true);
    config2.setSaveCredentials(true);
    config2.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest2 = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest2.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest2.setConfig(config2);
    singleEntityVersionCreateRequest2.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertEquals(singleEntityVersionCreateRequest, singleEntityVersionCreateRequest2);
    int expectedHashCodeResult = singleEntityVersionCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, singleEntityVersionCreateRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityVersionCreateRequest#equals(Object)}
   *   <li>{@link SingleEntityVersionCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionCreateConfig config = new VersionCreateConfig();
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    // Act and Assert
    assertEquals(singleEntityVersionCreateRequest, singleEntityVersionCreateRequest);
    int expectedHashCodeResult = singleEntityVersionCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, singleEntityVersionCreateRequest.hashCode());
  }

  /**
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VersionCreateConfig config = new VersionCreateConfig();
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("1.0.2");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    VersionCreateConfig config2 = new VersionCreateConfig();
    config2.setSaveAttributes(true);
    config2.setSaveCredentials(true);
    config2.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest2 = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest2.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest2.setConfig(config2);
    singleEntityVersionCreateRequest2.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(singleEntityVersionCreateRequest, singleEntityVersionCreateRequest2);
  }

  /**
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AutoVersionCreateConfig config = new AutoVersionCreateConfig();
    config.setBranch("janedoe/featurebranch");
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    VersionCreateConfig config2 = new VersionCreateConfig();
    config2.setSaveAttributes(true);
    config2.setSaveCredentials(true);
    config2.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest2 = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest2.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest2.setConfig(config2);
    singleEntityVersionCreateRequest2.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(singleEntityVersionCreateRequest, singleEntityVersionCreateRequest2);
  }

  /**
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AutoVersionCreateConfig config = mock(AutoVersionCreateConfig.class);
    doNothing().when(config).setSaveAttributes(anyBoolean());
    doNothing().when(config).setSaveCredentials(anyBoolean());
    doNothing().when(config).setSaveRelations(anyBoolean());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    VersionCreateConfig config2 = new VersionCreateConfig();
    config2.setSaveAttributes(true);
    config2.setSaveCredentials(true);
    config2.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest2 = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest2.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest2.setConfig(config2);
    singleEntityVersionCreateRequest2.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(singleEntityVersionCreateRequest, singleEntityVersionCreateRequest2);
  }

  /**
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AutoVersionCreateConfig config = mock(AutoVersionCreateConfig.class);
    doNothing().when(config).setSaveAttributes(anyBoolean());
    doNothing().when(config).setSaveCredentials(anyBoolean());
    doNothing().when(config).setSaveRelations(anyBoolean());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(null);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    VersionCreateConfig config2 = new VersionCreateConfig();
    config2.setSaveAttributes(true);
    config2.setSaveCredentials(true);
    config2.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest2 = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest2.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest2.setConfig(config2);
    singleEntityVersionCreateRequest2.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(singleEntityVersionCreateRequest, singleEntityVersionCreateRequest2);
  }

  /**
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AutoVersionCreateConfig config = mock(AutoVersionCreateConfig.class);
    doNothing().when(config).setSaveAttributes(anyBoolean());
    doNothing().when(config).setSaveCredentials(anyBoolean());
    doNothing().when(config).setSaveRelations(anyBoolean());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(new AlarmId(EntityId.NULL_UUID));
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    VersionCreateConfig config2 = new VersionCreateConfig();
    config2.setSaveAttributes(true);
    config2.setSaveCredentials(true);
    config2.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest2 = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest2.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest2.setConfig(config2);
    singleEntityVersionCreateRequest2.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(singleEntityVersionCreateRequest, singleEntityVersionCreateRequest2);
  }

  /**
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AutoVersionCreateConfig config = mock(AutoVersionCreateConfig.class);
    doNothing().when(config).setSaveAttributes(anyBoolean());
    doNothing().when(config).setSaveCredentials(anyBoolean());
    doNothing().when(config).setSaveRelations(anyBoolean());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(null);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    VersionCreateConfig config2 = new VersionCreateConfig();
    config2.setSaveAttributes(true);
    config2.setSaveCredentials(true);
    config2.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest2 = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest2.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest2.setConfig(config2);
    singleEntityVersionCreateRequest2.setEntityId(null);
    singleEntityVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(singleEntityVersionCreateRequest, singleEntityVersionCreateRequest2);
  }

  /**
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    VersionCreateConfig config = new VersionCreateConfig();
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(singleEntityVersionCreateRequest, null);
  }

  /**
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    VersionCreateConfig config = new VersionCreateConfig();
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(singleEntityVersionCreateRequest, "Different type to SingleEntityVersionCreateRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SingleEntityVersionCreateRequest}
   *   <li>{@link SingleEntityVersionCreateRequest#setConfig(VersionCreateConfig)}
   *   <li>{@link SingleEntityVersionCreateRequest#setEntityId(EntityId)}
   *   <li>{@link SingleEntityVersionCreateRequest#toString()}
   *   <li>{@link SingleEntityVersionCreateRequest#getConfig()}
   *   <li>{@link SingleEntityVersionCreateRequest#getEntityId()}
   *   <li>{@link SingleEntityVersionCreateRequest#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SingleEntityVersionCreateRequest actualSingleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    VersionCreateConfig config = new VersionCreateConfig();
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);
    actualSingleEntityVersionCreateRequest.setConfig(config);
    actualSingleEntityVersionCreateRequest.setEntityId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualSingleEntityVersionCreateRequest.toString();
    VersionCreateConfig actualConfig = actualSingleEntityVersionCreateRequest.getConfig();
    EntityId actualEntityId = actualSingleEntityVersionCreateRequest.getEntityId();

    // Assert that nothing has changed
    assertEquals(
        "SingleEntityVersionCreateRequest(entityId=13814000-1dd2-11b2-8080-808080808080, config=VersionCreateConfig"
            + "(saveRelations=true, saveAttributes=true, saveCredentials=true))",
        actualToStringResult);
    assertEquals(VersionCreateRequestType.SINGLE_ENTITY, actualSingleEntityVersionCreateRequest.getType());
    assertSame(config, actualConfig);
    assertSame(((TenantId) actualEntityId).SYS_TENANT_ID, actualEntityId);
  }
}
