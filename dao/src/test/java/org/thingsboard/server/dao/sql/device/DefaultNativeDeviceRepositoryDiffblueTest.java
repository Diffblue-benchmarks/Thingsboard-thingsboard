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

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.DeviceIdInfo;
import org.thingsboard.server.common.data.page.PageData;

@ContextConfiguration(classes = {DefaultNativeDeviceRepository.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNativeDeviceRepositoryDiffblueTest {
  @Autowired private DefaultNativeDeviceRepository defaultNativeDeviceRepository;

  @MockBean private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link DefaultNativeDeviceRepository#findDeviceIdInfos(Pageable)}.
   *
   * <p>Method under test: {@link DefaultNativeDeviceRepository#findDeviceIdInfos(Pageable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DefaultNativeDeviceRepository.findDeviceIdInfos(Pageable)"})
  public void testFindDeviceIdInfos() throws TransactionException {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult =
        defaultNativeDeviceRepository.findDeviceIdInfos(null);

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }
}
