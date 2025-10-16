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
package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageDataIterableByTenant.FetchFunction;

class PageDataIterableByTenantDiffblueTest {
  /**
   * Test {@link PageDataIterableByTenant#PageDataIterableByTenant(FetchFunction, TenantId, int)}.
   *
   * <p>Method under test: {@link PageDataIterableByTenant#PageDataIterableByTenant(FetchFunction,
   * TenantId, int)}
   */
  @Test
  @DisplayName("Test new PageDataIterableByTenant(FetchFunction, TenantId, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageDataIterableByTenant.<init>(FetchFunction, TenantId, int)"})
  void testNewPageDataIterableByTenant() {
    // Arrange and Act
    PageDataIterableByTenant<Object> actualPageDataIterableByTenant =
        new PageDataIterableByTenant<>(mock(FetchFunction.class), TenantId.SYS_TENANT_ID, 3);

    // Assert
    assertFalse(actualPageDataIterableByTenant.hasNext());
  }

  /**
   * Test {@link PageDataIterableByTenant#fetchPageData(PageLink)}.
   *
   * <p>Method under test: {@link PageDataIterableByTenant#fetchPageData(PageLink)}
   */
  @Test
  @DisplayName("Test fetchPageData(PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData PageDataIterableByTenant.fetchPageData(PageLink)"})
  void testFetchPageData() {
    // Arrange
    FetchFunction<Object> function = mock(FetchFunction.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(function.fetch(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageDataIterableByTenant<Object> pageDataIterableByTenant =
        new PageDataIterableByTenant<>(function, TenantId.SYS_TENANT_ID, 3);

    // Act
    PageData<Object> actualFetchPageDataResult =
        pageDataIterableByTenant.fetchPageData(new PageLink(3));

    // Assert
    verify(function).fetch(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFetchPageDataResult);
  }
}
