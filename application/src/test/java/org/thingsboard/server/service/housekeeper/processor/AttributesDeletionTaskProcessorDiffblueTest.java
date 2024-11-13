package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.housekeeper.EntitiesDeletionHousekeeperTask;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTask;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.housekeeper.HousekeeperClient;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;

@ContextConfiguration(classes = {AttributesDeletionTaskProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AttributesDeletionTaskProcessorDiffblueTest {
  @Autowired
  private AttributesDeletionTaskProcessor attributesDeletionTaskProcessor;

  @MockBean
  private AttributesService attributesService;

  @MockBean
  private HousekeeperClient housekeeperClient;

  /**
   * Test {@link AttributesDeletionTaskProcessor#process(HousekeeperTask)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then calls
   * {@link AttributesService#removeAllByEntityId(TenantId, EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AttributesDeletionTaskProcessor#process(HousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(HousekeeperTask); when TenantId(UUID) with id is randomUUID; then calls removeAllByEntityId(TenantId, EntityId)")
  void testProcess_whenTenantIdWithIdIsRandomUUID_thenCallsRemoveAllByEntityId() throws Exception {
    // Arrange
    when(attributesService.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(1);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    attributesDeletionTaskProcessor
        .process(new EntitiesDeletionHousekeeperTask(tenantId, EntityType.TENANT, new ArrayList<>()));

    // Assert
    verify(attributesService).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link AttributesDeletionTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link AttributesDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  void testGetTaskType() {
    // Arrange, Act and Assert
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES,
        (new AttributesDeletionTaskProcessor(new BaseAttributesService(new JpaAttributeDao()))).getTaskType());
  }
}
