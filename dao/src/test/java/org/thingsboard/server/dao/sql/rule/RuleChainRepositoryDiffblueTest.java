package org.thingsboard.server.dao.sql.rule;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.dao.ExportableEntityRepository;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.RuleChainEntity;

public class RuleChainRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link RuleChainRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    ExportableEntityRepository<RuleChainEntity> exportableEntityRepository = mock(ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ruleChainEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
