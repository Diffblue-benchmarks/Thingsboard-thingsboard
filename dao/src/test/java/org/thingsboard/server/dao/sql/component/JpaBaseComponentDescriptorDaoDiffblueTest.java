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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.id.ComponentDescriptorId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.plugin.ComponentClusteringMode;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentScope;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.ComponentDescriptorEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaBaseComponentDescriptorDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaBaseComponentDescriptorDaoDiffblueTest {
  @MockBean private ComponentDescriptorInsertRepository componentDescriptorInsertRepository;

  @MockBean private ComponentDescriptorRepository componentDescriptorRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaBaseComponentDescriptorDao jpaBaseComponentDescriptorDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaBaseComponentDescriptorDao#getEntityClass()}
   *   <li>{@link JpaBaseComponentDescriptorDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaBaseComponentDescriptorDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaBaseComponentDescriptorDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaBaseComponentDescriptorDao jpaBaseComponentDescriptorDao =
        new JpaBaseComponentDescriptorDao();

    // Act
    Class<ComponentDescriptorEntity> actualEntityClass =
        jpaBaseComponentDescriptorDao.getEntityClass();

    // Assert
    assertNull(jpaBaseComponentDescriptorDao.getRepository());
    Class<ComponentDescriptorEntity> expectedEntityClass = ComponentDescriptorEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}.
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JpaBaseComponentDescriptorDao.saveIfNotExist(TenantId, ComponentDescriptor)"
  })
  public void testSaveIfNotExist() {
    // Arrange
    when(componentDescriptorRepository.existsById(Mockito.<UUID>any())).thenReturn(true);
    ComponentDescriptor component =
        new ComponentDescriptor(new ComponentDescriptorId(ModelConstants.NULL_UUID));

    // Act
    Optional<ComponentDescriptor> actualSaveIfNotExistResult =
        jpaBaseComponentDescriptorDao.saveIfNotExist(ModelConstants.SYSTEM_TENANT, component);

    // Assert
    verify(componentDescriptorRepository).existsById(isA(UUID.class));
    assertEquals(0L, component.getCreatedTime());
    assertFalse(actualSaveIfNotExistResult.isPresent());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link ComponentDescriptorInsertRepository}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JpaBaseComponentDescriptorDao.saveIfNotExist(TenantId, ComponentDescriptor)"
  })
  public void testSaveIfNotExist_givenComponentDescriptorInsertRepository_thenReturnNotPresent() {
    // Arrange
    when(componentDescriptorRepository.existsById(Mockito.<UUID>any())).thenReturn(true);

    ComponentDescriptorId componentDescriptorId = mock(ComponentDescriptorId.class);
    when(componentDescriptorId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ComponentDescriptor component = mock(ComponentDescriptor.class);
    when(component.getId()).thenReturn(componentDescriptorId);

    // Act
    Optional<ComponentDescriptor> actualSaveIfNotExistResult =
        jpaBaseComponentDescriptorDao.saveIfNotExist(ModelConstants.SYSTEM_TENANT, component);

    // Assert
    verify(componentDescriptorRepository).existsById(isA(UUID.class));
    verify(componentDescriptorId).getId();
    verify(component, atLeast(1)).getId();
    assertFalse(actualSaveIfNotExistResult.isPresent());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ComponentDescriptor} {@link ComponentDescriptor#getCreatedTime()} return
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JpaBaseComponentDescriptorDao.saveIfNotExist(TenantId, ComponentDescriptor)"
  })
  public void testSaveIfNotExist_givenZero_whenComponentDescriptorGetCreatedTimeReturnZero() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    when(componentDescriptorInsertRepository.saveOrUpdate(Mockito.<ComponentDescriptorEntity>any()))
        .thenReturn(componentDescriptorEntity);
    when(componentDescriptorRepository.existsById(Mockito.<UUID>any())).thenReturn(false);

    ComponentDescriptorId componentDescriptorId = mock(ComponentDescriptorId.class);
    when(componentDescriptorId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ComponentDescriptor component = mock(ComponentDescriptor.class);
    when(component.isHasQueueName()).thenReturn(true);
    when(component.getConfigurationDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(component.getConfigurationVersion()).thenReturn(1);
    when(component.getActions()).thenReturn("Actions");
    when(component.getClazz()).thenReturn("Clazz");
    when(component.getName()).thenReturn("Name");
    when(component.getCreatedTime()).thenReturn(0L);
    when(component.getClusteringMode()).thenReturn(ComponentClusteringMode.USER_PREFERENCE);
    when(component.getScope()).thenReturn(ComponentScope.SYSTEM);
    when(component.getType()).thenReturn(ComponentType.ENRICHMENT);
    when(component.getId()).thenReturn(componentDescriptorId);

    // Act
    Optional<ComponentDescriptor> actualSaveIfNotExistResult =
        jpaBaseComponentDescriptorDao.saveIfNotExist(ModelConstants.SYSTEM_TENANT, component);

    // Assert
    verify(componentDescriptorRepository).existsById(isA(UUID.class));
    verify(componentDescriptorId, atLeast(1)).getId();
    verify(component).getActions();
    verify(component).getClazz();
    verify(component).getClusteringMode();
    verify(component).getConfigurationDescriptor();
    verify(component).getConfigurationVersion();
    verify(component).getCreatedTime();
    verify(component, atLeast(1)).getId();
    verify(component).getName();
    verify(component).getScope();
    verify(component).getType();
    verify(component).isHasQueueName();
    verify(componentDescriptorInsertRepository).saveOrUpdate(isA(ComponentDescriptorEntity.class));
    ComponentDescriptor getResult = actualSaveIfNotExistResult.get();
    assertTrue(getResult.getConfigurationDescriptor() instanceof ObjectNode);
    assertEquals("Actions", getResult.getActions());
    assertEquals("Clazz", getResult.getClazz());
    assertEquals("Name", getResult.getName());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, getResult.getClusteringMode());
    assertEquals(ComponentScope.SYSTEM, getResult.getScope());
    assertEquals(ComponentType.ENRICHMENT, getResult.getType());
    assertTrue(actualSaveIfNotExistResult.isPresent());
    assertTrue(getResult.isHasQueueName());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}.
   *
   * <ul>
   *   <li>When {@link ComponentDescriptor} {@link ComponentDescriptor#getCreatedTime()} return one.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JpaBaseComponentDescriptorDao.saveIfNotExist(TenantId, ComponentDescriptor)"
  })
  public void testSaveIfNotExist_whenComponentDescriptorGetCreatedTimeReturnOne() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    when(componentDescriptorInsertRepository.saveOrUpdate(Mockito.<ComponentDescriptorEntity>any()))
        .thenReturn(componentDescriptorEntity);
    when(componentDescriptorRepository.existsById(Mockito.<UUID>any())).thenReturn(false);

    ComponentDescriptorId componentDescriptorId = mock(ComponentDescriptorId.class);
    when(componentDescriptorId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ComponentDescriptor component = mock(ComponentDescriptor.class);
    when(component.isHasQueueName()).thenReturn(true);
    when(component.getConfigurationDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(component.getConfigurationVersion()).thenReturn(1);
    when(component.getActions()).thenReturn("Actions");
    when(component.getClazz()).thenReturn("Clazz");
    when(component.getName()).thenReturn("Name");
    when(component.getCreatedTime()).thenReturn(1L);
    when(component.getClusteringMode()).thenReturn(ComponentClusteringMode.USER_PREFERENCE);
    when(component.getScope()).thenReturn(ComponentScope.SYSTEM);
    when(component.getType()).thenReturn(ComponentType.ENRICHMENT);
    when(component.getId()).thenReturn(componentDescriptorId);

    // Act
    Optional<ComponentDescriptor> actualSaveIfNotExistResult =
        jpaBaseComponentDescriptorDao.saveIfNotExist(ModelConstants.SYSTEM_TENANT, component);

    // Assert
    verify(componentDescriptorRepository).existsById(isA(UUID.class));
    verify(componentDescriptorId, atLeast(1)).getId();
    verify(component).getActions();
    verify(component).getClazz();
    verify(component).getClusteringMode();
    verify(component).getConfigurationDescriptor();
    verify(component).getConfigurationVersion();
    verify(component).getCreatedTime();
    verify(component, atLeast(1)).getId();
    verify(component).getName();
    verify(component).getScope();
    verify(component).getType();
    verify(component).isHasQueueName();
    verify(componentDescriptorInsertRepository).saveOrUpdate(isA(ComponentDescriptorEntity.class));
    ComponentDescriptor getResult = actualSaveIfNotExistResult.get();
    assertTrue(getResult.getConfigurationDescriptor() instanceof ObjectNode);
    assertEquals("Actions", getResult.getActions());
    assertEquals("Clazz", getResult.getClazz());
    assertEquals("Name", getResult.getName());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, getResult.getClusteringMode());
    assertEquals(ComponentScope.SYSTEM, getResult.getScope());
    assertEquals(ComponentType.ENRICHMENT, getResult.getType());
    assertTrue(actualSaveIfNotExistResult.isPresent());
    assertTrue(getResult.isHasQueueName());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}.
   *
   * <ul>
   *   <li>When {@link ComponentDescriptor#ComponentDescriptor()}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JpaBaseComponentDescriptorDao.saveIfNotExist(TenantId, ComponentDescriptor)"
  })
  public void testSaveIfNotExist_whenComponentDescriptor_thenReturnNotPresent() {
    // Arrange
    when(componentDescriptorRepository.existsById(Mockito.<UUID>any())).thenReturn(true);

    // Act
    Optional<ComponentDescriptor> actualSaveIfNotExistResult =
        jpaBaseComponentDescriptorDao.saveIfNotExist(
            ModelConstants.SYSTEM_TENANT, new ComponentDescriptor());

    // Assert
    verify(componentDescriptorRepository).existsById(isA(UUID.class));
    assertFalse(actualSaveIfNotExistResult.isPresent());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findById(TenantId, ComponentDescriptorId)} with
   * {@code tenantId}, {@code componentId}.
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#findById(TenantId,
   * ComponentDescriptorId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComponentDescriptor JpaBaseComponentDescriptorDao.findById(TenantId, ComponentDescriptorId)"
  })
  public void testFindByIdWithTenantIdComponentId() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<ComponentDescriptorEntity> ofResult = Optional.of(componentDescriptorEntity);
    when(componentDescriptorRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    ComponentDescriptorId componentId = mock(ComponentDescriptorId.class);
    when(componentId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ComponentDescriptor actualFindByIdResult =
        jpaBaseComponentDescriptorDao.findById(ModelConstants.SYSTEM_TENANT, componentId);

    // Assert
    verify(componentDescriptorRepository).findById(isA(UUID.class));
    verify(componentId).getId();
    JsonNode configurationDescriptor = actualFindByIdResult.getConfigurationDescriptor();
    Iterator<JsonNode> iteratorResult = configurationDescriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configurationDescriptor instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(configurationDescriptor.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findById(TenantId, ComponentDescriptorId)} with
   * {@code tenantId}, {@code componentId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#findById(TenantId,
   * ComponentDescriptorId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComponentDescriptor JpaBaseComponentDescriptorDao.findById(TenantId, ComponentDescriptorId)"
  })
  public void testFindByIdWithTenantIdComponentId_thenReturnNull() {
    // Arrange
    Optional<ComponentDescriptorEntity> emptyResult = Optional.empty();
    when(componentDescriptorRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);

    ComponentDescriptorId componentId = mock(ComponentDescriptorId.class);
    when(componentId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ComponentDescriptor actualFindByIdResult =
        jpaBaseComponentDescriptorDao.findById(ModelConstants.SYSTEM_TENANT, componentId);

    // Assert
    verify(componentDescriptorRepository).findById(isA(UUID.class));
    verify(componentId).getId();
    assertNull(actualFindByIdResult);
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findById(TenantId, ComponentDescriptorId)} with
   * {@code tenantId}, {@code componentId}.
   *
   * <ul>
   *   <li>When {@link ComponentDescriptorId#ComponentDescriptorId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#findById(TenantId,
   * ComponentDescriptorId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComponentDescriptor JpaBaseComponentDescriptorDao.findById(TenantId, ComponentDescriptorId)"
  })
  public void testFindByIdWithTenantIdComponentId_whenComponentDescriptorIdWithIdIsNull_uuid() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<ComponentDescriptorEntity> ofResult = Optional.of(componentDescriptorEntity);
    when(componentDescriptorRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    ComponentDescriptor actualFindByIdResult =
        jpaBaseComponentDescriptorDao.findById(
            ModelConstants.SYSTEM_TENANT, new ComponentDescriptorId(ModelConstants.NULL_UUID));

    // Assert
    verify(componentDescriptorRepository).findById(isA(UUID.class));
    JsonNode configurationDescriptor = actualFindByIdResult.getConfigurationDescriptor();
    Iterator<JsonNode> iteratorResult = configurationDescriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configurationDescriptor instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(configurationDescriptor.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findByClazz(TenantId, String)}.
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#findByClazz(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComponentDescriptor JpaBaseComponentDescriptorDao.findByClazz(TenantId, String)"
  })
  public void testFindByClazz() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    when(componentDescriptorRepository.findByClazz(Mockito.<String>any()))
        .thenReturn(componentDescriptorEntity);

    // Act
    ComponentDescriptor actualFindByClazzResult =
        jpaBaseComponentDescriptorDao.findByClazz(ModelConstants.SYSTEM_TENANT, "Clazz");

    // Assert
    verify(componentDescriptorRepository).findByClazz("Clazz");
    assertTrue(actualFindByClazzResult.getConfigurationDescriptor() instanceof ObjectNode);
    assertEquals("Actions", actualFindByClazzResult.getActions());
    assertEquals("Clazz", actualFindByClazzResult.getClazz());
    assertEquals("Name", actualFindByClazzResult.getName());
    assertEquals(1, actualFindByClazzResult.getConfigurationVersion());
    assertEquals(1L, actualFindByClazzResult.getCreatedTime());
    assertEquals(
        ComponentClusteringMode.USER_PREFERENCE, actualFindByClazzResult.getClusteringMode());
    assertEquals(ComponentScope.SYSTEM, actualFindByClazzResult.getScope());
    assertEquals(ComponentType.ENRICHMENT, actualFindByClazzResult.getType());
    assertTrue(actualFindByClazzResult.isHasQueueName());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseComponentDescriptorDao.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(componentDescriptorRepository.findByType(
            Mockito.<ComponentType>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult =
        jpaBaseComponentDescriptorDao.findByTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(componentDescriptorRepository)
        .findByType(eq(ComponentType.ENRICHMENT), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseComponentDescriptorDao.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<ComponentDescriptorEntity> content = new ArrayList<>();
    content.add(componentDescriptorEntity);
    when(componentDescriptorRepository.findByType(
            Mockito.<ComponentType>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult =
        jpaBaseComponentDescriptorDao.findByTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(componentDescriptorRepository)
        .findByType(eq(ComponentType.ENRICHMENT), eq("Text Search"), isA(Pageable.class));
    List<ComponentDescriptor> data = actualFindByTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    ComponentDescriptor getResult = data.get(0);
    assertTrue(getResult.getConfigurationDescriptor() instanceof ObjectNode);
    assertEquals("Actions", getResult.getActions());
    assertEquals("Clazz", getResult.getClazz());
    assertEquals("Name", getResult.getName());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, actualFindByTypeAndPageLinkResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, getResult.getClusteringMode());
    assertEquals(ComponentScope.SYSTEM, getResult.getScope());
    assertEquals(ComponentType.ENRICHMENT, getResult.getType());
    assertTrue(getResult.isHasQueueName());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseComponentDescriptorDao.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(componentDescriptorRepository.findByType(
            Mockito.<ComponentType>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult =
        jpaBaseComponentDescriptorDao.findByTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            ComponentType.ENRICHMENT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(componentDescriptorRepository)
        .findByType(eq(ComponentType.ENRICHMENT), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId,
   * ComponentScope, ComponentType, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseComponentDescriptorDao.findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)"
  })
  public void testFindByScopeAndTypeAndPageLink_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(componentDescriptorRepository.findByScopeAndType(
            Mockito.<ComponentType>any(),
            Mockito.<ComponentScope>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult =
        jpaBaseComponentDescriptorDao.findByScopeAndTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            ComponentScope.SYSTEM,
            ComponentType.ENRICHMENT,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(componentDescriptorRepository)
        .findByScopeAndType(
            eq(ComponentType.ENRICHMENT),
            eq(ComponentScope.SYSTEM),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindByScopeAndTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByScopeAndTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByScopeAndTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByScopeAndTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId,
   * ComponentScope, ComponentType, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseComponentDescriptorDao.findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)"
  })
  public void testFindByScopeAndTypeAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<ComponentDescriptorEntity> content = new ArrayList<>();
    content.add(componentDescriptorEntity);
    when(componentDescriptorRepository.findByScopeAndType(
            Mockito.<ComponentType>any(),
            Mockito.<ComponentScope>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult =
        jpaBaseComponentDescriptorDao.findByScopeAndTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            ComponentScope.SYSTEM,
            ComponentType.ENRICHMENT,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(componentDescriptorRepository)
        .findByScopeAndType(
            eq(ComponentType.ENRICHMENT),
            eq(ComponentScope.SYSTEM),
            eq("Text Search"),
            isA(Pageable.class));
    List<ComponentDescriptor> data = actualFindByScopeAndTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    ComponentDescriptor getResult = data.get(0);
    assertTrue(getResult.getConfigurationDescriptor() instanceof ObjectNode);
    assertEquals("Actions", getResult.getActions());
    assertEquals("Clazz", getResult.getClazz());
    assertEquals("Name", getResult.getName());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, actualFindByScopeAndTypeAndPageLinkResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, getResult.getClusteringMode());
    assertEquals(ComponentScope.SYSTEM, getResult.getScope());
    assertEquals(ComponentType.ENRICHMENT, getResult.getType());
    assertTrue(getResult.isHasQueueName());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId,
   * ComponentScope, ComponentType, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseComponentDescriptorDao.findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)"
  })
  public void testFindByScopeAndTypeAndPageLink_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(componentDescriptorRepository.findByScopeAndType(
            Mockito.<ComponentType>any(),
            Mockito.<ComponentScope>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult =
        jpaBaseComponentDescriptorDao.findByScopeAndTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            ComponentScope.SYSTEM,
            ComponentType.ENRICHMENT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(componentDescriptorRepository)
        .findByScopeAndType(
            eq(ComponentType.ENRICHMENT), eq(ComponentScope.SYSTEM), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByScopeAndTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByScopeAndTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByScopeAndTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByScopeAndTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#deleteById(TenantId, ComponentDescriptorId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link ComponentDescriptorId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#deleteById(TenantId,
   * ComponentDescriptorId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JpaBaseComponentDescriptorDao.deleteById(TenantId, ComponentDescriptorId)"
  })
  public void testDeleteById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(componentDescriptorRepository).flush();
    doNothing().when(componentDescriptorRepository).deleteById(Mockito.<UUID>any());

    ComponentDescriptorId componentId = mock(ComponentDescriptorId.class);
    when(componentId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaBaseComponentDescriptorDao.deleteById(ModelConstants.SYSTEM_TENANT, componentId);

    // Assert
    verify(componentDescriptorRepository).flush();
    verify(componentDescriptorRepository).deleteById(isA(UUID.class));
    verify(componentId).getId();
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#deleteById(TenantId, ComponentDescriptorId)}.
   *
   * <ul>
   *   <li>When {@link ComponentDescriptorId#ComponentDescriptorId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link ComponentDescriptorRepository#flush()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#deleteById(TenantId,
   * ComponentDescriptorId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JpaBaseComponentDescriptorDao.deleteById(TenantId, ComponentDescriptorId)"
  })
  public void testDeleteById_whenComponentDescriptorIdWithIdIsNull_uuid_thenCallsFlush() {
    // Arrange
    doNothing().when(componentDescriptorRepository).flush();
    doNothing().when(componentDescriptorRepository).deleteById(Mockito.<UUID>any());

    // Act
    jpaBaseComponentDescriptorDao.deleteById(
        ModelConstants.SYSTEM_TENANT, new ComponentDescriptorId(ModelConstants.NULL_UUID));

    // Assert
    verify(componentDescriptorRepository).flush();
    verify(componentDescriptorRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#deleteByClazz(TenantId, String)}.
   *
   * <p>Method under test: {@link JpaBaseComponentDescriptorDao#deleteByClazz(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseComponentDescriptorDao.deleteByClazz(TenantId, String)"})
  public void testDeleteByClazz() {
    // Arrange
    doNothing().when(componentDescriptorRepository).deleteByClazz(Mockito.<String>any());

    // Act
    jpaBaseComponentDescriptorDao.deleteByClazz(ModelConstants.SYSTEM_TENANT, "Clazz");

    // Assert
    verify(componentDescriptorRepository).deleteByClazz("Clazz");
  }
}
