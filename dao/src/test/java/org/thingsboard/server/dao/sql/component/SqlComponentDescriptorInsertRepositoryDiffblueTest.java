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
package org.thingsboard.server.dao.sql.component;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;
import org.thingsboard.server.common.data.plugin.ComponentClusteringMode;
import org.thingsboard.server.common.data.plugin.ComponentScope;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.ComponentDescriptorEntity;

@RunWith(MockitoJUnitRunner.class)
public class SqlComponentDescriptorInsertRepositoryDiffblueTest {
  @Mock private PlatformTransactionManager platformTransactionManager;

  @InjectMocks
  private SqlComponentDescriptorInsertRepository sqlComponentDescriptorInsertRepository;

  /**
   * Test {@link SqlComponentDescriptorInsertRepository#saveOrUpdate(ComponentDescriptorEntity)}.
   *
   * <p>Method under test: {@link
   * SqlComponentDescriptorInsertRepository#saveOrUpdate(ComponentDescriptorEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComponentDescriptorEntity SqlComponentDescriptorInsertRepository.saveOrUpdate(ComponentDescriptorEntity)"
  })
  public void testSaveOrUpdate() throws TransactionException {
    // Arrange
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus());
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ComponentDescriptorEntity entity = new ComponentDescriptorEntity();
    entity.setActions("Actions");
    entity.setClazz("Clazz");
    entity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    entity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entity.setConfigurationVersion(1);
    entity.setCreatedTime(1L);
    entity.setHasQueueName(true);
    entity.setId(ModelConstants.NULL_UUID);
    entity.setName("Name");
    entity.setScope(ComponentScope.SYSTEM);
    entity.setType(ComponentType.ENRICHMENT);
    entity.setUuid(ModelConstants.NULL_UUID);

    // Act
    ComponentDescriptorEntity actualSaveOrUpdateResult =
        sqlComponentDescriptorInsertRepository.saveOrUpdate(entity);

    // Assert
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    assertNull(actualSaveOrUpdateResult);
  }
}
