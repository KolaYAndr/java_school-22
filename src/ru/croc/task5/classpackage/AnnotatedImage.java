package src.ru.croc.task5.classpackage;

class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;


    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByLabel(String label) {
        for (Annotation annotation : annotations) {
            if (annotation.getSignature().contains(label)) return annotation;
        }
        return null;
    }

    public Annotation findByPoint(double x, double y) {
        for (Annotation annotation : annotations) {
            if (annotation.pointIsInside(x, y)) return annotation;
        }
        return null;
    }
}