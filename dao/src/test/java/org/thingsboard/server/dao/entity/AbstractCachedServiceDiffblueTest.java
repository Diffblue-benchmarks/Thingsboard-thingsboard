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
package org.thingsboard.server.dao.entity;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsCompositeKey;
import org.thingsboard.server.dao.user.UserSettingsDao;
import org.thingsboard.server.dao.user.UserSettingsEvictEvent;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;

@ContextConfiguration(classes = {UserSettingsServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractCachedServiceDiffblueTest {
  @Autowired
  private AbstractCachedService<UserSettingsCompositeKey, UserSettings, UserSettingsEvictEvent>
      abstractCachedService;

  @MockBean
  private TbTransactionalCache<UserSettingsCompositeKey, UserSettings> tbTransactionalCache;

  @MockBean private UserSettingsDao userSettingsDao;

  /**
   * Test {@link AbstractCachedService#publishEvictEvent(Object)}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCachedService#publishEvictEvent(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCachedService.publishEvictEvent(Object)"})
  public void testPublishEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());

    // Act
    abstractCachedService.publishEvictEvent(
        new UserSettingsEvictEvent(new UserSettingsCompositeKey()));

    // Assert
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
  }
}
