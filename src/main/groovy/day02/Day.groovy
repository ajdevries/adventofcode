package day02

import DefaultDay

class Day extends DefaultDay {
    def wrappingpaper(dimensions) {
        summarize dimensions, { dimension ->
            def lwh = dimension.split('x').collect { it as Integer }
            def surfaces = [lwh[0] * lwh[1], lwh[1] * lwh[2], lwh[0] * lwh[2]]
            surfaces.sum { it * 2 } + surfaces.min()
        }
    }

    def ribbons(dimensions) {
        summarize dimensions, { dimension ->
            def lwh = dimension.split('x').collect { it as Integer }
            lwh.sort().take(2).sum { it * 2 } + lwh.inject(1) { product, val -> product * val }
        }
    }

    protected def summarize(dimensions, closure) {
        dimensions.split('\n').sum closure
    }

}
