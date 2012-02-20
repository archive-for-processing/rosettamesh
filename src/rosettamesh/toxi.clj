(ns rosettamesh.toxi
  (:use rosettamesh.util)
)

(import  '(toxi.geom Vec3D mesh.TriangleMesh))

(defn fromToxi [toximesh] 
  (map (fn [face]
      (map (fn [vertex]
          (callList vertex x y z))
        (callList face a b c)))
  (.faces toximesh)))

(defn toToxi [faceList]
  (let [mesh (TriangleMesh.)
          v3d  (fn [[x y z]] (Vec3D. x y z))]
    (last (map (fn [[a b c]]
      (.addFace mesh (v3d a) (v3d b) (v3d c)))
    faceList))))




