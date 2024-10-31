import { TestBed } from '@angular/core/testing';

import { DentistesService } from './dentistes.service';

describe('DentistesService', () => {
  let service: DentistesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DentistesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
