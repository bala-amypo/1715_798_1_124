@Override
public void deactivateTarget(Long id) {
    DiversityTarget target = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    target.setActive(false);
    repository.save(target);
}
