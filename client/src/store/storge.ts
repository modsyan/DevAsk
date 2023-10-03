export interface IStorage {
  get(key: string): Promise<string>;
  add(key: string, value: string): Promise<string>;
  delete(key: string): Promise<string>;
}

class Storage implements IStorage {

  constructor(private storage: Promise<string[]>) {}

  get(key: string): Promise<string> {
    // return await this.storage.getItem(key);
    throw new Error('Method not implemented.');
  }
  add(key: string, value: string): Promise<string> {
    throw new Error('Method not implemented.');
  }
  delete(key: string): Promise<string> {
    throw new Error('Method not implemented.');
  }
}
