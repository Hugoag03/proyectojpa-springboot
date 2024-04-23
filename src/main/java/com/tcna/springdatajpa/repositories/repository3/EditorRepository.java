package com.tcna.springdatajpa.repositories.repository3;

import com.tcna.springdatajpa.entitites.entity3.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {
}
