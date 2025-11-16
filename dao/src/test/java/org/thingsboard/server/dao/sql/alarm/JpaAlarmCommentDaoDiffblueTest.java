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
package org.thingsboard.server.dao.sql.alarm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.sql.AlarmCommentEntity;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

public class JpaAlarmCommentDaoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaAlarmCommentDao#getEntityClass()}
   *   <li>{@link JpaAlarmCommentDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaAlarmCommentDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaAlarmCommentDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaAlarmCommentDao jpaAlarmCommentDao =
        new JpaAlarmCommentDao(mock(SqlPartitioningRepository.class));

    // Act
    Class<AlarmCommentEntity> actualEntityClass = jpaAlarmCommentDao.getEntityClass();

    // Assert
    assertNull(jpaAlarmCommentDao.getRepository());
    Class<AlarmCommentEntity> expectedEntityClass = AlarmCommentEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
