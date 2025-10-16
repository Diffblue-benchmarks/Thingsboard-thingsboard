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
package org.thingsboard.server.dao.sql.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DeviceCredentialsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDeviceCredentialsDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaDeviceCredentialsDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private DeviceCredentialsRepository deviceCredentialsRepository;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaDeviceCredentialsDao jpaDeviceCredentialsDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaDeviceCredentialsDao#getEntityClass()}
   *   <li>{@link JpaDeviceCredentialsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaDeviceCredentialsDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaDeviceCredentialsDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaDeviceCredentialsDao jpaDeviceCredentialsDao = new JpaDeviceCredentialsDao();

    // Act
    Class<DeviceCredentialsEntity> actualEntityClass = jpaDeviceCredentialsDao.getEntityClass();

    // Assert
    assertNull(jpaDeviceCredentialsDao.getRepository());
    Class<DeviceCredentialsEntity> expectedEntityClass = DeviceCredentialsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDeviceCredentialsDao#findByDeviceId(TenantId, UUID)}.
   *
   * <p>Method under test: {@link JpaDeviceCredentialsDao#findByDeviceId(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceCredentials JpaDeviceCredentialsDao.findByDeviceId(TenantId, UUID)"})
  public void testFindByDeviceId() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);
    when(deviceCredentialsRepository.findByDeviceId(Mockito.<UUID>any()))
        .thenReturn(deviceCredentialsEntity);
    UUID deviceId = ModelConstants.NULL_UUID;

    // Act
    DeviceCredentials actualFindByDeviceIdResult =
        jpaDeviceCredentialsDao.findByDeviceId(ModelConstants.SYSTEM_TENANT, deviceId);

    // Assert
    verify(deviceCredentialsRepository).findByDeviceId(isA(UUID.class));
    assertEquals("42", actualFindByDeviceIdResult.getCredentialsId());
    assertEquals("42", actualFindByDeviceIdResult.getCredentialsValue());
    assertEquals(1L, actualFindByDeviceIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByDeviceIdResult.getCreatedTime());
    DeviceId deviceId2 = actualFindByDeviceIdResult.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    assertEquals(
        DeviceCredentialsType.ACCESS_TOKEN, actualFindByDeviceIdResult.getCredentialsType());
    assertTrue(deviceId2.isNullUid());
    assertSame(deviceId, actualFindByDeviceIdResult.getUuidId());
    assertSame(deviceId, deviceId2.getId());
    assertSame(deviceId, actualFindByDeviceIdResult.getId().getId());
  }

  /**
   * Test {@link JpaDeviceCredentialsDao#findByCredentialsId(TenantId, String)}.
   *
   * <p>Method under test: {@link JpaDeviceCredentialsDao#findByCredentialsId(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials JpaDeviceCredentialsDao.findByCredentialsId(TenantId, String)"
  })
  public void testFindByCredentialsId() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);
    when(deviceCredentialsRepository.findByCredentialsId(Mockito.<String>any()))
        .thenReturn(deviceCredentialsEntity);

    // Act
    DeviceCredentials actualFindByCredentialsIdResult =
        jpaDeviceCredentialsDao.findByCredentialsId(ModelConstants.SYSTEM_TENANT, "42");

    // Assert
    verify(deviceCredentialsRepository).findByCredentialsId("42");
    UUID uuidId = actualFindByCredentialsIdResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", actualFindByCredentialsIdResult.getCredentialsId());
    assertEquals("42", actualFindByCredentialsIdResult.getCredentialsValue());
    assertEquals(1L, actualFindByCredentialsIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByCredentialsIdResult.getCreatedTime());
    DeviceId deviceId = actualFindByCredentialsIdResult.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId.getEntityType());
    assertEquals(
        DeviceCredentialsType.ACCESS_TOKEN, actualFindByCredentialsIdResult.getCredentialsType());
    assertTrue(deviceId.isNullUid());
    assertSame(uuidId, deviceId.getId());
    assertSame(uuidId, actualFindByCredentialsIdResult.getId().getId());
  }

  /**
   * Test {@link JpaDeviceCredentialsDao#removeByDeviceId(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return DeviceId EntityType is {@code DEVICE}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceCredentialsDao#removeByDeviceId(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials JpaDeviceCredentialsDao.removeByDeviceId(TenantId, DeviceId)"
  })
  public void testRemoveByDeviceId_givenNull_uuid_thenReturnDeviceIdEntityTypeIsDevice() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);
    when(deviceCredentialsRepository.deleteByDeviceId(Mockito.<UUID>any()))
        .thenReturn(deviceCredentialsEntity);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DeviceCredentials actualRemoveByDeviceIdResult =
        jpaDeviceCredentialsDao.removeByDeviceId(ModelConstants.SYSTEM_TENANT, deviceId);

    // Assert
    verify(deviceId).getId();
    verify(deviceCredentialsRepository).deleteByDeviceId(isA(UUID.class));
    UUID uuidId = actualRemoveByDeviceIdResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", actualRemoveByDeviceIdResult.getCredentialsId());
    assertEquals("42", actualRemoveByDeviceIdResult.getCredentialsValue());
    assertEquals(1L, actualRemoveByDeviceIdResult.getVersion().longValue());
    assertEquals(1L, actualRemoveByDeviceIdResult.getCreatedTime());
    DeviceId deviceId2 = actualRemoveByDeviceIdResult.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    assertEquals(
        DeviceCredentialsType.ACCESS_TOKEN, actualRemoveByDeviceIdResult.getCredentialsType());
    assertTrue(deviceId2.isNullUid());
    assertSame(uuidId, deviceId2.getId());
    assertSame(uuidId, actualRemoveByDeviceIdResult.getId().getId());
  }

  /**
   * Test {@link JpaDeviceCredentialsDao#removeByDeviceId(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Then return DeviceId is {@link DeviceId#DeviceId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceCredentialsDao#removeByDeviceId(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials JpaDeviceCredentialsDao.removeByDeviceId(TenantId, DeviceId)"
  })
  public void testRemoveByDeviceId_thenReturnDeviceIdIsDeviceIdWithIdIsNull_uuid() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);
    when(deviceCredentialsRepository.deleteByDeviceId(Mockito.<UUID>any()))
        .thenReturn(deviceCredentialsEntity);
    DeviceId deviceId = new DeviceId(ModelConstants.NULL_UUID);

    // Act
    DeviceCredentials actualRemoveByDeviceIdResult =
        jpaDeviceCredentialsDao.removeByDeviceId(ModelConstants.SYSTEM_TENANT, deviceId);

    // Assert
    verify(deviceCredentialsRepository).deleteByDeviceId(isA(UUID.class));
    UUID uuidId = actualRemoveByDeviceIdResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", actualRemoveByDeviceIdResult.getCredentialsId());
    assertEquals("42", actualRemoveByDeviceIdResult.getCredentialsValue());
    assertEquals(1L, actualRemoveByDeviceIdResult.getVersion().longValue());
    assertEquals(1L, actualRemoveByDeviceIdResult.getCreatedTime());
    assertEquals(
        DeviceCredentialsType.ACCESS_TOKEN, actualRemoveByDeviceIdResult.getCredentialsType());
    assertEquals(deviceId, actualRemoveByDeviceIdResult.getDeviceId());
    assertSame(uuidId, actualRemoveByDeviceIdResult.getId().getId());
  }
}
