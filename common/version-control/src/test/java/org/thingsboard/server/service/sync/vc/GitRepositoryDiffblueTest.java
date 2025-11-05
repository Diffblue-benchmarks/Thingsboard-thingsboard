package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.HashSet;
import java.util.Set;
import org.apache.sshd.sftp.client.SftpClient;
import org.apache.sshd.sftp.client.SftpClient.Attributes;
import org.apache.sshd.sftp.client.fs.SftpPosixFileAttributes;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffEntry.ChangeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.service.sync.vc.GitRepository.Commit;
import org.thingsboard.server.service.sync.vc.GitRepository.Diff;
import org.thingsboard.server.service.sync.vc.GitRepository.Status;

@ExtendWith(MockitoExtension.class)
class GitRepositoryDiffblueTest {
  @Mock private RepositorySettings repositorySettings;

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Commit#equals(Object)}
   *   <li>{@link Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Commit commit =
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org");
    Commit commit2 =
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertEquals(commit, commit2);
    assertEquals(commit.hashCode(), commit2.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Commit#equals(Object)}
   *   <li>{@link Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Commit commit =
        new Commit(10L, null, "Not all who wander are lost", "JaneDoe", "jane.doe@example.org");
    Commit commit2 =
        new Commit(10L, null, "Not all who wander are lost", "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertEquals(commit, commit2);
    assertEquals(commit.hashCode(), commit2.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Commit#equals(Object)}
   *   <li>{@link Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Commit commit = new Commit(10L, "42", null, "JaneDoe", "jane.doe@example.org");
    Commit commit2 = new Commit(10L, "42", null, "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertEquals(commit, commit2);
    assertEquals(commit.hashCode(), commit2.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Commit#equals(Object)}
   *   <li>{@link Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Commit commit =
        new Commit(10L, "42", "Not all who wander are lost", null, "jane.doe@example.org");
    Commit commit2 =
        new Commit(10L, "42", "Not all who wander are lost", null, "jane.doe@example.org");

    // Act and Assert
    assertEquals(commit, commit2);
    assertEquals(commit.hashCode(), commit2.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Commit#equals(Object)}
   *   <li>{@link Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Commit commit = new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", null);
    Commit commit2 = new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", null);

    // Act and Assert
    assertEquals(commit, commit2);
    assertEquals(commit.hashCode(), commit2.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Commit#equals(Object)}
   *   <li>{@link Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Commit commit =
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertEquals(commit, commit);
    int expectedHashCodeResult = commit.hashCode();
    assertEquals(expectedHashCodeResult, commit.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Commit commit =
        new Commit(1L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(
        commit,
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Commit commit =
        new Commit(
            10L,
            "Not all who wander are lost",
            "Not all who wander are lost",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(
        commit,
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Commit commit =
        new Commit(10L, null, "Not all who wander are lost", "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(
        commit,
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Commit commit = new Commit(10L, "42", "42", "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(
        commit,
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Commit commit = new Commit(10L, "42", null, "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(
        commit,
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Commit commit =
        new Commit(10L, "42", "Not all who wander are lost", "42", "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(
        commit,
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Commit commit =
        new Commit(10L, "42", "Not all who wander are lost", null, "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(
        commit,
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Commit commit =
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "john.smith@example.org");

    // Act and Assert
    assertNotEquals(
        commit,
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Commit commit = new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", null);

    // Act and Assert
    assertNotEquals(
        commit,
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"),
        null);
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Commit.equals(Object)", "int Commit.hashCode()"})
  void testCommitEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"),
        "Different type to Commit");
  }

  /**
   * Test Commit getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Commit#toString()}
   *   <li>{@link Commit#getAuthorEmail()}
   *   <li>{@link Commit#getAuthorName()}
   *   <li>{@link Commit#getId()}
   *   <li>{@link Commit#getMessage()}
   *   <li>{@link Commit#getTimestamp()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Commit.getAuthorEmail()",
    "String Commit.getAuthorName()",
    "String Commit.getId()",
    "String Commit.getMessage()",
    "long Commit.getTimestamp()",
    "String Commit.toString()"
  })
  void testCommitGettersAndSetters() {
    // Arrange
    Commit commit =
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org");

    // Act
    String actualToStringResult = commit.toString();
    String actualAuthorEmail = commit.getAuthorEmail();
    String actualAuthorName = commit.getAuthorName();
    String actualId = commit.getId();
    String actualMessage = commit.getMessage();

    // Assert
    assertEquals("42", actualId);
    assertEquals(
        "GitRepository.Commit(timestamp=10, id=42, message=Not all who wander are lost, authorName=JaneDoe,"
            + " authorEmail=jane.doe@example.org)",
        actualToStringResult);
    assertEquals("JaneDoe", actualAuthorName);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("jane.doe@example.org", actualAuthorEmail);
    assertEquals(10L, commit.getTimestamp());
  }

  /**
   * Test Commit {@link Commit#Commit(long, String, String, String, String)}.
   *
   * <p>Method under test: {@link Commit#Commit(long, String, String, String, String)}
   */
  @Test
  @DisplayName("Test Commit new Commit(long, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Commit.<init>(long, String, String, String, String)"})
  void testCommitNewCommit() {
    // Arrange and Act
    Commit actualCommit =
        new Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org");

    // Assert
    assertEquals("42", actualCommit.getId());
    assertEquals("JaneDoe", actualCommit.getAuthorName());
    assertEquals("Not all who wander are lost", actualCommit.getMessage());
    assertEquals("jane.doe@example.org", actualCommit.getAuthorEmail());
    assertEquals(10L, actualCommit.getTimestamp());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Diff#equals(Object)}
   *   <li>{@link Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff2);
    assertEquals(diff.hashCode(), diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Diff#equals(Object)}
   *   <li>{@link Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(null);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(null);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff2);
    assertEquals(diff.hashCode(), diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Diff#equals(Object)}
   *   <li>{@link Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue(null);
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue(null);
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff2);
    assertEquals(diff.hashCode(), diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Diff#equals(Object)}
   *   <li>{@link Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1(null);
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1(null);
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff2);
    assertEquals(diff.hashCode(), diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Diff#equals(Object)}
   *   <li>{@link Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2(null);
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2(null);
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff2);
    assertEquals(diff.hashCode(), diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Diff#equals(Object)}
   *   <li>{@link Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath(null);

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath(null);

    // Act and Assert
    assertEquals(diff, diff2);
    assertEquals(diff.hashCode(), diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Diff#equals(Object)}
   *   <li>{@link Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff);
    int expectedHashCodeResult = diff.hashCode();
    assertEquals(expectedHashCodeResult, diff.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(null);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.MODIFY);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("/directory/foo.txt");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue(null);
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("/directory/foo.txt");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1(null);
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("/directory/foo.txt");
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2(null);
    diff.setFilePath("/directory/foo.txt");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("Not all who wander are lost");

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath(null);

    Diff diff2 = new Diff();
    diff2.setChangeType(ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, null);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diff.equals(Object)", "int Diff.hashCode()"})
  void testDiffEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Diff diff = new Diff();
    diff.setChangeType(ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, "Different type to Diff");
  }

  /**
   * Test Diff getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Diff}
   *   <li>{@link Diff#setChangeType(ChangeType)}
   *   <li>{@link Diff#setDiffStringValue(String)}
   *   <li>{@link Diff#setFileContentAtCommit1(String)}
   *   <li>{@link Diff#setFileContentAtCommit2(String)}
   *   <li>{@link Diff#setFilePath(String)}
   *   <li>{@link Diff#toString()}
   *   <li>{@link Diff#getChangeType()}
   *   <li>{@link Diff#getDiffStringValue()}
   *   <li>{@link Diff#getFileContentAtCommit1()}
   *   <li>{@link Diff#getFileContentAtCommit2()}
   *   <li>{@link Diff#getFilePath()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Diff.<init>()",
    "ChangeType Diff.getChangeType()",
    "String Diff.getDiffStringValue()",
    "String Diff.getFileContentAtCommit1()",
    "String Diff.getFileContentAtCommit2()",
    "String Diff.getFilePath()",
    "void Diff.setChangeType(ChangeType)",
    "void Diff.setDiffStringValue(String)",
    "void Diff.setFileContentAtCommit1(String)",
    "void Diff.setFileContentAtCommit2(String)",
    "void Diff.setFilePath(String)",
    "String Diff.toString()"
  })
  void testDiffGettersAndSetters() {
    // Arrange and Act
    Diff actualDiff = new Diff();
    actualDiff.setChangeType(ChangeType.ADD);
    actualDiff.setDiffStringValue("42");
    actualDiff.setFileContentAtCommit1("Not all who wander are lost");
    actualDiff.setFileContentAtCommit2("Not all who wander are lost");
    actualDiff.setFilePath("/directory/foo.txt");
    String actualToStringResult = actualDiff.toString();
    ChangeType actualChangeType = actualDiff.getChangeType();
    String actualDiffStringValue = actualDiff.getDiffStringValue();
    String actualFileContentAtCommit1 = actualDiff.getFileContentAtCommit1();
    String actualFileContentAtCommit2 = actualDiff.getFileContentAtCommit2();

    // Assert
    assertEquals("/directory/foo.txt", actualDiff.getFilePath());
    assertEquals("42", actualDiffStringValue);
    assertEquals(
        "GitRepository.Diff(filePath=/directory/foo.txt, changeType=ADD, fileContentAtCommit1=Not all who wander"
            + " are lost, fileContentAtCommit2=Not all who wander are lost, diffStringValue=42)",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualFileContentAtCommit1);
    assertEquals("Not all who wander are lost", actualFileContentAtCommit2);
    assertEquals(ChangeType.ADD, actualChangeType);
  }

  /**
   * Test {@link GitRepository#openOrClone(Path, RepositorySettings, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getRepositoryUri()}.
   * </ul>
   *
   * <p>Method under test: {@link GitRepository#openOrClone(Path, RepositorySettings, boolean)}
   */
  @Test
  @DisplayName("Test openOrClone(Path, RepositorySettings, boolean); then calls getRepositoryUri()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GitRepository GitRepository.openOrClone(Path, RepositorySettings, boolean)"})
  void testOpenOrClone_thenCallsGetRepositoryUri() throws IOException, GitAPIException {
    // Arrange
    when(repositorySettings.getRepositoryUri()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            GitRepository.openOrClone(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
                repositorySettings,
                true));
    verify(repositorySettings).getRepositoryUri();
  }

  /**
   * Test {@link GitRepository#openOrClone(Path, RepositorySettings, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link Files#isDirectory(Path, LinkOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link GitRepository#openOrClone(Path, RepositorySettings, boolean)}
   */
  @Test
  @DisplayName(
      "Test openOrClone(Path, RepositorySettings, boolean); then calls isDirectory(Path, LinkOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GitRepository GitRepository.openOrClone(Path, RepositorySettings, boolean)"})
  void testOpenOrClone_thenCallsIsDirectory() throws IOException, GitAPIException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.newDirectoryStream(Mockito.<Path>any()))
          .thenThrow(new IllegalArgumentException());
      mockFiles.when(() -> Files.deleteIfExists(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles.when(() -> Files.isSymbolicLink(Mockito.<Path>any())).thenReturn(true);
      Path path = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
      SftpPosixFileAttributes sftpPosixFileAttributes =
          new SftpPosixFileAttributes(path, new Attributes());
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(), eq(PosixFileAttributes.class), isA(LinkOption[].class)))
          .thenReturn(sftpPosixFileAttributes);
      mockFiles
          .when(
              () ->
                  Files.getFileAttributeView(
                      Mockito.<Path>any(), eq(DosFileAttributeView.class), isA(LinkOption[].class)))
          .thenReturn(null);
      Path directory = Paths.get(System.getProperty("java.io.tmpdir"), ".git");

      // Act and Assert
      assertThrows(
          IllegalArgumentException.class,
          () -> GitRepository.openOrClone(directory, new RepositorySettings(), true));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newDirectoryStream(Mockito.<Path>any()));
    }
  }

  /**
   * Test {@link GitRepository#exists(String)}.
   *
   * <ul>
   *   <li>When {@code /directory}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GitRepository#exists(String)}
   */
  @Test
  @DisplayName("Test exists(String); when '/directory'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GitRepository.exists(String)"})
  void testExists_whenDirectory_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(GitRepository.exists("/directory"));
  }

  /**
   * Test Status {@link Status#equals(Object)}, and {@link Status#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Status#equals(Object)}
   *   <li>{@link Status#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Status equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Status.equals(Object)", "int Status.hashCode()"})
  void testStatusEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    HashSet<String> modified = new HashSet<>();

    Status status = new Status(added, modified, new HashSet<>());
    HashSet<String> added2 = new HashSet<>();
    HashSet<String> modified2 = new HashSet<>();

    Status status2 = new Status(added2, modified2, new HashSet<>());

    // Act and Assert
    assertEquals(status, status2);
    assertEquals(status.hashCode(), status2.hashCode());
  }

  /**
   * Test Status {@link Status#equals(Object)}, and {@link Status#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Status#equals(Object)}
   *   <li>{@link Status#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Status equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Status.equals(Object)", "int Status.hashCode()"})
  void testStatusEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    HashSet<String> modified = new HashSet<>();

    Status status = new Status(added, modified, new HashSet<>());

    // Act and Assert
    assertEquals(status, status);
    int expectedHashCodeResult = status.hashCode();
    assertEquals(expectedHashCodeResult, status.hashCode());
  }

  /**
   * Test Status {@link Status#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Status#equals(Object)}
   */
  @Test
  @DisplayName("Test Status equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Status.equals(Object)", "int Status.hashCode()"})
  void testStatusEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    added.add("foo");
    HashSet<String> modified = new HashSet<>();

    Status status = new Status(added, modified, new HashSet<>());
    HashSet<String> added2 = new HashSet<>();
    HashSet<String> modified2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(status, new Status(added2, modified2, new HashSet<>()));
  }

  /**
   * Test Status {@link Status#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Status#equals(Object)}
   */
  @Test
  @DisplayName("Test Status equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Status.equals(Object)", "int Status.hashCode()"})
  void testStatusEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    HashSet<String> modified = new HashSet<>();

    // Act and Assert
    assertNotEquals(new Status(added, modified, new HashSet<>()), null);
  }

  /**
   * Test Status {@link Status#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Status#equals(Object)}
   */
  @Test
  @DisplayName("Test Status equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Status.equals(Object)", "int Status.hashCode()"})
  void testStatusEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    HashSet<String> modified = new HashSet<>();

    // Act and Assert
    assertNotEquals(new Status(added, modified, new HashSet<>()), "Different type to Status");
  }

  /**
   * Test Status getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Status#Status(Set, Set, Set)}
   *   <li>{@link Status#toString()}
   *   <li>{@link Status#getAdded()}
   *   <li>{@link Status#getModified()}
   *   <li>{@link Status#getRemoved()}
   * </ul>
   */
  @Test
  @DisplayName("Test Status getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Status.<init>(Set, Set, Set)",
    "Set Status.getAdded()",
    "Set Status.getModified()",
    "Set Status.getRemoved()",
    "String Status.toString()"
  })
  void testStatusGettersAndSetters() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    HashSet<String> modified = new HashSet<>();
    HashSet<String> removed = new HashSet<>();

    // Act
    Status actualStatus = new Status(added, modified, removed);
    String actualToStringResult = actualStatus.toString();
    Set<String> actualAdded = actualStatus.getAdded();
    Set<String> actualModified = actualStatus.getModified();
    Set<String> actualRemoved = actualStatus.getRemoved();

    // Assert
    assertEquals("GitRepository.Status(added=[], modified=[], removed=[])", actualToStringResult);
    assertTrue(actualAdded.isEmpty());
    assertTrue(actualModified.isEmpty());
    assertTrue(actualRemoved.isEmpty());
    assertSame(added, actualAdded);
    assertSame(modified, actualModified);
    assertSame(removed, actualRemoved);
  }
}
