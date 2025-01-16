package org.thingsboard.server.actors.device;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbEntityActorId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {DeviceActorCreator.class, TenantId.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DeviceActorCreatorDiffblueTest {
  @MockBean
  private ActorSystemContext actorSystemContext;

  @Autowired
  private DeviceActorCreator deviceActorCreator;

  @MockBean
  private DeviceId deviceId;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link DeviceActorCreator#createActorId()}.
   * <p>
   * Method under test: {@link DeviceActorCreator#createActorId()}
   */
  @Test
  @DisplayName("Test createActorId()")
  void testCreateActorId() {
    // Arrange and Act
    TbActorId actualCreateActorIdResult = deviceActorCreator.createActorId();

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbEntityActorId);
    assertNull(actualCreateActorIdResult.getEntityType());
  }
}
