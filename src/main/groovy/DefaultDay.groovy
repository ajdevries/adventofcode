class DefaultDay {
    def methodMissing(String name, args) {
        "solution not found"
    }

    def problems() {
        def defaultMethods = ['equals', 'getClass', 'getMetaClass',
         'getProperty', 'hashCode', 'invokeMethod', 'methodMissing', 'notify', 'notifyAll', 'problems', 'setMetaClass', 'setProperty', 'toString', 'wait']
        this.metaClass.methods*.name.sort().unique() - defaultMethods
    }
}
