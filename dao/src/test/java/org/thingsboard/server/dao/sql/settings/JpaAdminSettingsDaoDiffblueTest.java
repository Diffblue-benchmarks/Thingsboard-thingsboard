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
package org.thingsboard.server.dao.sql.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.EntityManagerFactory;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AdminSettingsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaAdminSettingsDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAdminSettingsDaoDiffblueTest {
  @MockBean private AdminSettingsRepository adminSettingsRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaAdminSettingsDao jpaAdminSettingsDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaAdminSettingsDao#getEntityClass()}
   *   <li>{@link JpaAdminSettingsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaAdminSettingsDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaAdminSettingsDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaAdminSettingsDao jpaAdminSettingsDao = new JpaAdminSettingsDao();

    // Act
    Class<AdminSettingsEntity> actualEntityClass = jpaAdminSettingsDao.getEntityClass();

    // Assert
    assertNull(jpaAdminSettingsDao.getRepository());
    Class<AdminSettingsEntity> expectedEntityClass = AdminSettingsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaAdminSettingsDao#findByTenantIdAndKey(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsEntity#AdminSettingsEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAdminSettingsDao#findByTenantIdAndKey(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSettings JpaAdminSettingsDao.findByTenantIdAndKey(UUID, String)"})
  public void testFindByTenantIdAndKey_givenAdminSettingsEntityTenantIdIsNull_uuid() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    when(adminSettingsRepository.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(adminSettingsEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    AdminSettings actualFindByTenantIdAndKeyResult =
        jpaAdminSettingsDao.findByTenantIdAndKey(tenantId, "Key");

    // Assert
    verify(adminSettingsRepository).findByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertTrue(actualFindByTenantIdAndKeyResult.getJsonValue() instanceof ObjectNode);
    assertEquals("Key", actualFindByTenantIdAndKeyResult.getKey());
    assertEquals(1L, actualFindByTenantIdAndKeyResult.getCreatedTime());
    assertSame(tenantId, actualFindByTenantIdAndKeyResult.getUuidId());
  }

  /**
   * Test {@link JpaAdminSettingsDao#findByTenantIdAndKey(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsEntity#AdminSettingsEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAdminSettingsDao#findByTenantIdAndKey(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSettings JpaAdminSettingsDao.findByTenantIdAndKey(UUID, String)"})
  public void testFindByTenantIdAndKey_givenAdminSettingsEntityTenantIdIsRandomUUID() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(UUID.randomUUID());
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    when(adminSettingsRepository.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(adminSettingsEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    AdminSettings actualFindByTenantIdAndKeyResult =
        jpaAdminSettingsDao.findByTenantIdAndKey(tenantId, "Key");

    // Assert
    verify(adminSettingsRepository).findByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertTrue(actualFindByTenantIdAndKeyResult.getJsonValue() instanceof ObjectNode);
    assertEquals("Key", actualFindByTenantIdAndKeyResult.getKey());
    assertEquals(1L, actualFindByTenantIdAndKeyResult.getCreatedTime());
    assertSame(tenantId, actualFindByTenantIdAndKeyResult.getUuidId());
  }

  /**
   * Test {@link JpaAdminSettingsDao#removeByTenantIdAndKey(UUID, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAdminSettingsDao#removeByTenantIdAndKey(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaAdminSettingsDao.removeByTenantIdAndKey(UUID, String)"})
  public void testRemoveByTenantIdAndKey_thenReturnFalse() {
    // Arrange
    when(adminSettingsRepository.existsByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualRemoveByTenantIdAndKeyResult =
        jpaAdminSettingsDao.removeByTenantIdAndKey(ModelConstants.NULL_UUID, "Key");

    // Assert
    verify(adminSettingsRepository).existsByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertFalse(actualRemoveByTenantIdAndKeyResult);
  }

  /**
   * Test {@link JpaAdminSettingsDao#removeByTenantIdAndKey(UUID, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAdminSettingsDao#removeByTenantIdAndKey(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaAdminSettingsDao.removeByTenantIdAndKey(UUID, String)"})
  public void testRemoveByTenantIdAndKey_thenReturnTrue() {
    // Arrange
    doNothing()
        .when(adminSettingsRepository)
        .deleteByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any());
    when(adminSettingsRepository.existsByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualRemoveByTenantIdAndKeyResult =
        jpaAdminSettingsDao.removeByTenantIdAndKey(ModelConstants.NULL_UUID, "Key");

    // Assert
    verify(adminSettingsRepository).deleteByTenantIdAndKey(isA(UUID.class), eq("Key"));
    verify(adminSettingsRepository).existsByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertTrue(actualRemoveByTenantIdAndKeyResult);
  }

  /**
   * Test {@link JpaAdminSettingsDao#removeByTenantId(UUID)}.
   *
   * <p>Method under test: {@link JpaAdminSettingsDao#removeByTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAdminSettingsDao.removeByTenantId(UUID)"})
  public void testRemoveByTenantId() {
    // Arrange
    doNothing().when(adminSettingsRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaAdminSettingsDao.removeByTenantId(ModelConstants.NULL_UUID);

    // Assert
    verify(adminSettingsRepository).deleteByTenantId(isA(UUID.class));
  }
}
