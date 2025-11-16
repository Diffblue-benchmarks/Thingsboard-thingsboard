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
package org.thingsboard.server.dao.sql.mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.MobileAppSettingsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaMobileAppSettingsDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaMobileAppSettingsDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaMobileAppSettingsDao jpaMobileAppSettingsDao;

  @MockBean private MobileAppSettingsRepository mobileAppSettingsRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaMobileAppSettingsDao#removeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppSettingsDao#removeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaMobileAppSettingsDao.removeByTenantId(TenantId)"})
  public void testRemoveByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(mobileAppSettingsRepository).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaMobileAppSettingsDao.removeByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(mobileAppSettingsRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaMobileAppSettingsDao#removeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link MobileAppSettingsRepository#deleteByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppSettingsDao#removeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaMobileAppSettingsDao.removeByTenantId(TenantId)"})
  public void testRemoveByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(mobileAppSettingsRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaMobileAppSettingsDao.removeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(mobileAppSettingsRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaMobileAppSettingsDao#getEntityClass()}
   *   <li>{@link JpaMobileAppSettingsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaMobileAppSettingsDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaMobileAppSettingsDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaMobileAppSettingsDao jpaMobileAppSettingsDao = new JpaMobileAppSettingsDao();

    // Act
    Class<MobileAppSettingsEntity> actualEntityClass = jpaMobileAppSettingsDao.getEntityClass();

    // Assert
    assertNull(jpaMobileAppSettingsDao.getRepository());
    Class<MobileAppSettingsEntity> expectedEntityClass = MobileAppSettingsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
