package org.thingsboard.server.common.data.sync.vc.request.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class SingleEntityVersionCreateRequestDiffblueTest {
  /**
   * Test {@link SingleEntityVersionCreateRequest#equals(Object)}, and
   * {@link SingleEntityVersionCreateRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityVersionCreateRequest#equals(Object)}
   *   <li>{@link SingleEntityVersionCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link SingleEntityVersionCreateRequest#equals(Object)}, and
   * {@link SingleEntityVersionCreateRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityVersionCreateRequest#equals(Object)}
   *   <li>{@link SingleEntityVersionCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link SingleEntityVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SingleEntityVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SingleEntityVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SingleEntityVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SingleEntityVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
    singleEntityVersionCreateRequest.setEntityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
   * Test {@link SingleEntityVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SingleEntityVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link SingleEntityVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
