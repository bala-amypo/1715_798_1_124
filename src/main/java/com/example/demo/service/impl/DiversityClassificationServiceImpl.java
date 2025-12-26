@Override
public void deactivateClassification(Long id) {
    DiversityClassification dc = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    dc.setActive(false);
    repository.save(dc);
}
